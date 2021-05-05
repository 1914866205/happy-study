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
 * @ClassName CreateWorkDto.java
 * @Description TODO
 * @createTime 2021年04月30日 16:40:00
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CreateWorkDto {
    private String positionName;
    private int startMoney;
    private int endMoney;
    private String workMonths;
    private String workCity;
    private String workExperience;
    private String qualification;
    private String pkUserId;
    private String company;
    private String position;
    private String workDetails;
    private String workNeed;
    private String pkWorkTypeId;
    private int status;
    private int workStatus;
}
