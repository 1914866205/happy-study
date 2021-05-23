package com.zs.yyds.service.impl;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.common.ResultCode;
import com.zs.yyds.modle.dto.*;
import com.zs.yyds.modle.entity.SysUser;
import com.zs.yyds.repository.SysUserRepository;
import com.zs.yyds.service.SendSmsService;
import com.zs.yyds.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    @Resource
    private SendSmsService sendSmsService;


    @Override
    public ResponseResult register(RegisterDto registerDto) {
        int size = sysUserRepository.findSysUsersByUserNameEquals(registerDto.getUserName()).size();
        //如果用户名已存在，返回注册失败
        if (size != 0) {
            return ResponseResult.failure(ResultCode.USERNAME_IS_ALWAYS_USER);
        }
        SysUser sysUser = SysUser.builder()
                .advance(registerDto.getAdvance())
                .age(registerDto.getAge())
                .avatarUrl(registerDto.getAvatarUrl())
                .isLookForJob(registerDto.getIsLookForJob())
                .studyExperience(registerDto.getStudyExperience())
                .createdTime(Timestamp.valueOf(LocalDateTime.now()))
                .credentials(registerDto.getCredentials())
                .email(registerDto.getEmail())
                .ideaCity(registerDto.getIdeaCity())
                .ideaMoney(registerDto.getIdeaMoney())
                .ideaPosition(registerDto.getIdeaPosition())
                .isCurrentStudent(registerDto.getIsCurrentStudent())
                .name(registerDto.getName())
                .password(registerDto.getPassword())
                .phone(registerDto.getPhone())
                .pkUserId(UUID.randomUUID().toString().substring(0, 15))
                .qualification(registerDto.getQualification())
                .sex(registerDto.getSex())
                .userName(registerDto.getUserName())
                .wxNumber(registerDto.getWxNumber())
                .workExperience(registerDto.getWorkExperience())
                .build();
        sysUserRepository.save(sysUser);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult delete(String pkUserId) {
        sysUserRepository.deleteById(pkUserId);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult loginByUserName(LoginDto loginDto) {
        /**
         * 1.根据用户名查找用户是否存在
         * 2.如果不存在该用户，返回用户不存在
         * 3.如果存在，判断对应密码是否一样
         */
        List<SysUser> users = sysUserRepository.findSysUsersByUserNameEquals(loginDto.getUsername());
        int size = users.size();
        if (size == 0) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        SysUser sysUser = users.get(0);
        if (sysUser.getPassword().equals(loginDto.getPassword())) {
            return ResponseResult.success(sysUser);
        } else {
            return ResponseResult.failure(ResultCode.USER_PASSWORD_ERROR);
        }
    }

    @Override
    public ResponseResult loginByPhone(VerifyPhoneDto verifyPhoneDto) {
        /**
         * 1.验证码是否验证通过
         * 2.不通过则返回验证码失效或错误
         * 3.通过则根据手机号查找用户
         * 4.如果手机号不存在，则显示该手机号用户不存在
         */
        boolean result = sendSmsService.verify(verifyPhoneDto);
        if (!result) {
            return ResponseResult.failure(ResultCode.USER_VERIFY_CODE_ERROR_TIMEOUT);
        }

        List<SysUser> users = sysUserRepository.findSysUsersByPhoneEquals(verifyPhoneDto.getPhoneNumber());
        int size = users.size();
        if (size == 0) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(users.get(0));
    }

    @Override
    public ResponseResult forgetPassword(PassWordDto passWordDto) {

        boolean result = sendSmsService.verify(VerifyPhoneDto.builder().phoneNumber(passWordDto.getPhoneNumber()).verifyCode(passWordDto.getVerifyCode()).build());
        if (!result) {
            return ResponseResult.failure(ResultCode.USER_VERIFY_CODE_ERROR_TIMEOUT);
        }

        List<SysUser> users = sysUserRepository.findSysUsersByPhoneEquals(passWordDto.getPhoneNumber());
        int size = users.size();
        if (size == 0) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        SysUser sysUser = users.get(0);
        sysUser.setPassword(passWordDto.getPassword());
        sysUserRepository.save(sysUser);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult editUser(EditUserDto editUserDto) {
        SysUser sysUser = sysUserRepository.getOne(editUserDto.getPkUserId());
        if (sysUser == null) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE, "查无此人");
        }
        SysUser newUser = SysUser.builder()
                .pkUserId(sysUser.getPkUserId())
                .userName(sysUser.getUserName())
                .age(editUserDto.getAge())
                .avatarUrl(editUserDto.getAvatarUrl())
                .credentials(editUserDto.getCredentials())
                .email(editUserDto.getEmail())
                .isCurrentStudent(editUserDto.getIsCurrentStudent())
                .name(editUserDto.getName())
                .password(editUserDto.getPassword())
                .isLookForJob(editUserDto.getIsLookForJob())
                .sex(editUserDto.getSex())
                .companyId(editUserDto.getCompanyId())
                .wxNumber(editUserDto.getWxNumber())
                .phone(editUserDto.getPhone())
                .qualification(editUserDto.getQualification())
                .ideaCity(editUserDto.getIdeaCity())
                .ideaPosition(editUserDto.getIdeaPosition())
                .ideaMoney(editUserDto.getIdeaMoney())
                .workExperience(editUserDto.getWorkExperience())
                .createdTime(sysUser.getCreatedTime())
                .credentials(editUserDto.getCredentials())
                .advance(editUserDto.getAdvance())
                .studyExperience(editUserDto.getStudyExperience())
                .build();
        sysUserRepository.save(newUser);
        return ResponseResult.success(newUser);
    }

    @Override
    public ResponseResult findUserByWork(String position) {
        List<SysUser> users = sysUserRepository.findSysUsersByIdeaPositionIsLike("%" + position + "%");
        return ResponseResult.success(users);
    }

    @Override
    public ResponseResult findUserByphoneNumber(String phoneNumber) {
        int size = sysUserRepository.findSysUsersByPhoneEquals(phoneNumber).size();
        if (size == 0) {
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PHONE_IS_ALWAYS_USER);
        }
    }

    @Override
    public ResponseResult findUserByUserName(String username) {
        int size = sysUserRepository.findSysUsersByUserNameEquals(username).size();
        if (size == 0) {
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.USERNAME_IS_ALWAYS_USER);
        }
    }

    @Override
    public ResponseResult findUserInfoById(String userId) {

        return ResponseResult.success(sysUserRepository.findById(userId));
    }
}























