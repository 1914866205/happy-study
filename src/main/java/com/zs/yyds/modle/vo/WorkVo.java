package com.zs.yyds.modle.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName WorkVo.java
 * @Description TODO
 * @createTime 2021年05月05日 08:11:00
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class WorkVo {
    private String workId;
    private String workName;
    private String address;
    private String workExperience;
    private String studyExperience;
    private String startMoney;
    private String endMoney;
}
