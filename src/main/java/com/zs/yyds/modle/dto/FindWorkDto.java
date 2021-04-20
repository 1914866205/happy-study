package com.zs.yyds.modle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName findWorkDto.java
 * @Description TODO
 * @createTime 2021年04月20日 22:13:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindWorkDto {
    private String pkWorkTypeId;
    private int workStatus;
}
