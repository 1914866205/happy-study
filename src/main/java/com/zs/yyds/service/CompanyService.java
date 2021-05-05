package com.zs.yyds.service;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CompanyDto;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CompanyService.java
 * @Description TODO
 * @createTime 2021年05月05日 07:32:00
 */
public interface CompanyService {
    /**
     * 查找所有公司简介
     * @return
     */
    ResponseResult findAll();

    /**
     * 查找公司详细信息
     * @param id
     * @return
     */
    ResponseResult findCompanyById(String id);

    /**
     * 添加公司
     * @param companyDto
     * @return
     */
    ResponseResult addCompany(CompanyDto companyDto);
}
