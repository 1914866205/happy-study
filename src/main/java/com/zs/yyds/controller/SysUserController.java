package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.LoginDto;
import com.zs.yyds.modle.dto.PassWordDto;
import com.zs.yyds.modle.dto.RegisterDto;
import com.zs.yyds.modle.dto.VerifyPhoneDto;
import com.zs.yyds.modle.entity.SysUser;
import com.zs.yyds.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysUserController.java
 * @Description TODO
 * @createTime 2021年04月15日 01:05:00
 */
//常祎看门
@Slf4j
@RestController
@RequestMapping(value = "/user/")
@Api(value = "SysUserController", tags = {"用户模块"})
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation(value = "添加用户", notes = "用户注册")
    @PostMapping("register")
    ResponseResult register(@RequestBody RegisterDto registerDto) {
        return sysUserService.register(registerDto);
    }

    @ApiOperation(value = "普通账号密码登录", notes = "普通账号密码登录")
    @PostMapping("loginByUsername")
    ResponseResult login(@RequestBody LoginDto loginDto) {
        return sysUserService.loginByUserName(loginDto);
    }

    @ApiOperation(value = "手机号登录", notes = "手机号登录")
    @PostMapping("loginByPhone")
    ResponseResult loginByPhone(@RequestBody VerifyPhoneDto verifyPhoneDto) {
        return sysUserService.loginByPhone(verifyPhoneDto);
    }



    @ApiOperation(value = "忘记密码", notes = "忘记密码")
    @PostMapping("forgetPassword")
    ResponseResult forgetPassword(@RequestBody PassWordDto passWordDto) {
        return sysUserService.forgetPassword(passWordDto);
    }







    @PostMapping("del")
    ResponseResult delete(String pkUserId) {
        return sysUserService.delete(pkUserId);
    }

    @GetMapping("hello")
    String hello() {
        return "hello";
    }
}
