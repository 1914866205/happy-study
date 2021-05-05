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
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Company.java
 * @Description TODO
 * @createTime 2021年05月04日 20:23:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Company {

    /**
     * 主键Id
     */
    @Id
    private String pkCompanyId;

    /**
     * 公司名称
     */
    @Column
    private String companyName;

    /**
     * 是否上市
     * 1 是    0 否
     */
    @Column
    private int isMarketing;

    /**
     * 公司规模枚举
     * 1 20以下
     * 2 21-50
     * 3 51-100
     * 4 101-500
     * 5 501-1000
     * 6 1001-5000
     * 7 5001-10000
     * 8 10000以上
     */
    @Column
    private String scale;

    /**
     * 公司类型枚举
     * 科技类
     * 文化、传媒广告类
     * 咨询类
     * 管理类
     * 商贸类
     */
    @Column
    private String companyType;

    /**
     * 每天工作时间
     */
    @Column
    private String workTime;

    /**
     * 1单休
     * 2双休
     */
    @Column
    private int freeTime;


    /**
     * 员工福利枚举
     * 五险一金 补充医疗保险 定期体检 年终奖 股票期权 带薪年假 员工旅游 免费班车 餐补 通讯补贴  交通补贴 节日福利 住房补贴 零食下午茶
     */
    @Column
    private String employeeWelfare;


    /**
     * 公司地址
     */
    @Column
    private String addresses;


    /**
     * 公司简介
     */
    @Column
    private String introduction;


    /**
     * 公司头像地址
     */
    @Column
    private String avatarUrl;


    /**
     * 公司照片地址
     */
    @Column
    private String album;


    /**
     * 该公司下boss名单
     */
    @Column
    private String pkUserId;


    /**
     * 该公司下职位名单
     */
    @Column
    private String pkWorkId;

    /**
     * 工商信息
     */
    @Column
    private String businessInformation;

    /**
     * 法定代表人
     */
    @Column
    private String bossName;

    /**
     * 注册资金
     */
    @Column
    private String registerMoney;

    /**
     * 上市时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp marketTime;

    /**
     * 创建时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdTime;
}
