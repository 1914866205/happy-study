package com.zs.yyds.repository;

import com.zs.yyds.modle.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysUserRepository.java
 * @Description TODO
 * @createTime 2021年04月15日 01:00:00
 */

//云琪保管

public interface SysUserRepository extends JpaRepository<SysUser, String> {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    List<SysUser> findSysUsersByUserNameEquals(String username);

    /**
     * 根据手机号查找用户
     * @param phone
     * @return
     */
    List<SysUser> findSysUsersByPhoneEquals(String phone);

}
