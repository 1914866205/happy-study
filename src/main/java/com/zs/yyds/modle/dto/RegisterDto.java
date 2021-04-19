package com.zs.yyds.modle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName RegisterDto.java
 * @Description TODO
 * @createTime 2021年04月19日 09:46:00
 */
@AllArgsConstructor //全参
@NoArgsConstructor //无参
@Builder
@Data
public class RegisterDto {
    private String userName;
    private String password;
    private String name;
    private int sex;
    private String wxNumber;
    private String phone;
    private String email;
    private String advance;
    private int age;
    private String qualification;
    private String avatarUrl;
    private int isCurrentStudent;
    private String ideaCity;
    private String ideaPosition;
    private int ideaMoney;
    private String workExperience;
    private String studyExperience;
    private String credentials;
}
