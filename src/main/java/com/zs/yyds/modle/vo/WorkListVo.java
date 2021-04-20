package com.zs.yyds.modle.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName WorkListVo.java
 * @Description TODO
 * @createTime 2021年04月20日 22:41:00
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class WorkListVo {
    private String pkWorkId;
    private String positionName;
    private int startMoney;
    private int endMoney;
    private String workMonths;
    private String workCity;
    private String qualification;
    private PublisherVo publisherVo;
    private String company;
    private String pkWorkTypeId;
    private int workStatus;
}
