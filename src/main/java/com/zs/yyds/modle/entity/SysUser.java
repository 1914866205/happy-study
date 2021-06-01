package com.zs.yyds.modle.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * @ClassName SysUser.java
 * @Description TODO
 * @createTime 2021年04月14日 22:42:00
 */
@AllArgsConstructor //全参33
@NoArgsConstructor //无参
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SysUser {
    /**
     * 主键Id
     */
    @Id
    private String pkUserId;

    /**
     * 账号
     */
    @Column
    private String userName;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 用户的名字
     */
    @Column
    private String name;

    /**
     * 性别
     */
    @Column
    private int sex;

    /**
     * 微信号
     */
    private String wxNumber;


    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 个人优势
     */
    @Column
    private String advance;

    /**
     * 年龄
     */
    @Column
    private int age;
    /**
     * 学历
     */
    @Column
    private String qualification;
    /**
     * 公司Id
     */
    @Column
    private String companyId;

    /**
     * 是否是求职者 0不是  1是
     */
    @Column
    private int isLookForJob;

    /**
     * 头像地址
     */
    @Column
    private String avatarUrl;
    /**
     * 是否是应届生
     * 0 否
     * 1 是
     */
    @Column
    private int isCurrentStudent;

    /**
     * 期望工作城市
     */
    @Column
    private String ideaCity;

    /**
     * 期望职位
     */
    @Column
    private String ideaPosition;
    /**
     * 期望薪资
     */
    @Column
    private int ideaMoney;

    /**
     * 工作经历
     */
    @Column
    private String workExperience;


    /**
     * 教育经历
     */
    @Column
    private String studyExperience;
    /**
     * 资格证书
     */
    @Column
    private String credentials;

    /**
     * 创建时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdTime;

}
