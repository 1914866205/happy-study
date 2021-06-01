package com.zs.yyds.modle.vo;

import com.zs.yyds.modle.entity.Company;
import com.zs.yyds.modle.entity.SysUser;
import com.zs.yyds.modle.entity.SysWork;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName WorkDetailVo.java
 * @Description TODO
 * @createTime 2021年05月23日 23:26:00
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class WorkDetailVo {
    private SysWork sysWork;
    private SysUser sysUser;
    private Company company;
}
