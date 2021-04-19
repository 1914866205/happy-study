package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.common.ResultCode;
import com.zs.yyds.modle.dto.SmsPhoneDto;
import com.zs.yyds.modle.dto.VerifyPhoneDto;
import com.zs.yyds.service.SendSmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SmsApiController.java
 * @Description TODO
 * @createTime 2021年04月19日 11:03:00
 */
@RestController
@Slf4j
@Api(value = "SmsApiController", tags = {"短信服务接口"})
public class SmsApiController {
    @Autowired
    private SendSmsService sendSmsService;

    @ApiOperation(value = "发送验证码", notes = "参数为 手机号")
    @PostMapping(value = "/sendCode")
    public ResponseResult code(@RequestBody SmsPhoneDto smsPhoneDto) {
        return sendSmsService.code(smsPhoneDto);
    }



    /**
     * 校验验证码
     * @param verifyPhone
     * @return
     */
    @ApiOperation(value = "校验验证码", tags = {"参数为手机号和接收的验证码"})
    @PostMapping(value = "/verifyCode")
    public ResponseResult verifyCode(@RequestBody VerifyPhoneDto verifyPhone) {
        if (sendSmsService.verify(verifyPhone)) {
            log.info("验证码通过");
            return ResponseResult.success(true);
        } else {
            log.info("验证码失效或错误");
            return ResponseResult.failure(ResultCode.USER_VERIFY_CODE_ERROR_TIMEOUT);
        }
    }

}
