package com.zs.yyds.service.impl;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.entity.SysUser;
import com.zs.yyds.repository.SysUserRepository;
import com.zs.yyds.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysUserServiceImpl.java
 * @Description TODO
 * @createTime 2021年04月15日 01:03:00
 */
//老朱拍大腿
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserRepository sysUserRepository;


    @Override
    public ResponseResult register(SysUser sysUser) {
        sysUserRepository.save(sysUser);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult delete(String pkUserId) {
        sysUserRepository.deleteById(pkUserId);
        return ResponseResult.success();
    }
}
