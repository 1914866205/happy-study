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
 * @ClassName CompanyDto.java
 * @Description TODO
 * @createTime 2021年05月05日 08:34:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyDto {

    private String companyName;
    private int isMarketing;
    private String scale;
    private String companyType;
    private String workTime;
    private int freeTime;
    private String employeeWelfare;
    private String addresses;
    private String introduction;
    private String avatarUrl;
    private String album;
    private String pkUserId;
    private String pkWorkId;
    private String businessInformation;
    private String bossName;
    private String registerMoney;
    private Timestamp marketTime;
}
