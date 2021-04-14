package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.entity.SysUser;
import com.zs.yyds.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PostMapping("add")
    ResponseResult register(@RequestBody SysUser sysUser) {
        return sysUserService.register(sysUser);
    }

    @PostMapping("del")
    ResponseResult delete(String pkUserId) {
        return sysUserService.delete(pkUserId);
    }

}
