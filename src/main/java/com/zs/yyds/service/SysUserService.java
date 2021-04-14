package com.zs.yyds.service;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.entity.SysUser;

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
     * @param sysUser
     * @return
     */
    ResponseResult register(SysUser sysUser);

    /**
     * 删除用户
     * @param pkUserId
     * @return
     */
    ResponseResult delete(String pkUserId);
}
