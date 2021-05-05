package com.zs.yyds.modle.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CompanyVo.java
 * @Description TODO
 * @createTime 2021年05月05日 07:59:00
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CompanyVo {
    private String companyId;
    private String companyName;
    private String avatarUrl;
    private int isSmart;
    private String scale;
    private String companyType;
    private List<WorkVo> workVoList;

}
