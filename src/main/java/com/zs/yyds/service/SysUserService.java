package com.zs.yyds.service;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.*;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysService.java
 * @Description TODO
 * @createTime 2021年04月15日 01:01:00
 */
public interface SysUserService {
    /**
     * 注册用户
     * @param registerDto
     * @return
     */
    ResponseResult register(RegisterDto registerDto);

    /**
     * 删除用户
     * @param pkUserId
     * @return
     */
    ResponseResult delete(String pkUserId);

    /**
     * 根据账号密码登录
     * @param loginDto
     * @return
     */
    ResponseResult loginByUserName(LoginDto loginDto);

    /**
     * 根据手机号登录
     * @param verifyPhoneDto
     * @return
     */
    ResponseResult loginByPhone(VerifyPhoneDto verifyPhoneDto);

    /**
     * 忘记密码
     * @param passWordDto
     * @return
     */
    ResponseResult forgetPassword(PassWordDto passWordDto);

    ResponseResult editUser(EditUserDto editUserDto);

    /**
     * 根据职位查找招聘者
     * @param position
     * @return
     */
    ResponseResult findUserByWork(String position);

    ResponseResult findUserByphoneNumber(String phoneNumber);

    ResponseResult findUserByUserName(String username);

    ResponseResult findUserInfoById(String userId);
}
