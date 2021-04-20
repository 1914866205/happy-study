package com.zs.yyds.modle.entity;

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
 * @author 张森
 * @version 1.0.0
 * @ClassName SysWork.java
 * @Description TODO
 * @createTime 2021年04月15日 00:19:00
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
public class SysWork {
    @Id
    private String pkWorkId;

    /**
     * 职位名称
     */
    @Column
    private String positionName;

    /**
     * 起始薪资
     */
    @Column
    private int startMoney;

    /**
     * 最高薪资
     */
    @Column
    private int endMoney;


    /**
     * 年终奖
     */
    @Column
    private String workMonths;


    /**
     * 工作地点
     */
    @Column
    private String workCity;

    /**
     * 工作经验
     */
    @Column
    private String workExperience;

    /**
     * 学历
     */
    @Column
    private String qualification;

    /**
     * 招聘人ID
     */
    @Column
    private String pkUserId;

    /**
     * 公司名称
     */
    @Column
    private String company;

    /**
     * 招聘人职位
     */
    @Column
    private String position;

    /**
     * 职位详情
     */
    @Column
    private String workDetails;

    /**
     * 岗位要求
     */
    @Column
    private String workNeed;


    /**
     * 类型id
     */
    private String pkWorkTypeId;

    /**
     * 招聘状态
     * 0 不招了
     * 1 正在招
     */
    private int status;

    /**
     * 0.全职
     * 1.兼职
     * 2.实习
     * 3.校招
     * 4.社招
     */
    private int workStatus;

    /**
     * 创建时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdTime;


}
