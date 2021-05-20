package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.*;
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

    @ApiOperation(value = "修改信息", notes = "修改信息")
    @PostMapping("editUser")
    ResponseResult editUser(@RequestBody EditUserDto editUserDto) {
        return sysUserService.editUser(editUserDto);
    }

    /**
     * 根据职位模糊查找招聘者
     * @param position
     * @return
     */
    @ApiOperation(value = "根据职位查找招聘者,直接请求则查找所有职位的用户", notes = "根据职位查找招聘者")
    @PostMapping("findUserByWork")
    ResponseResult findUserByWork(String position) {
        return sysUserService.findUserByWork(position);
    }


    /**
     * 查询手机号是否存在
     * @param phoneNumber
     * @return
     */
    @ApiOperation(value = "查询手机号是否存在", notes = "查询手机号是否存在")
    @PostMapping("phoneIsExist")
    ResponseResult phoneIsExist(String phoneNumber) {
        return sysUserService.findUserByphoneNumber(phoneNumber);
    }

    /**
     * 查询账号是否存在
     * @param username
     * @return
     */
    @ApiOperation(value = "查询账号是否存在", notes = "查询账号是否存在")
    @PostMapping("usernameIsExist")
    ResponseResult usernameIsExist(String username) {
        return sysUserService.findUserByUserName(username);
    }

    /**
     * 根据id获取用户信息
     * @param userId
     * @return
     */
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息")
    @PostMapping("findUserInfoById")
    ResponseResult findUserInfoById(String userId) {
        return sysUserService.findUserInfoById(userId);
    }
}
