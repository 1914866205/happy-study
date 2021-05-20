package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CompanyDto;
import com.zs.yyds.modle.dto.EditCompanyDto;
import com.zs.yyds.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CompanyController.java
 * @Description TODO
 * @createTime 2021年05月05日 07:33:00
 */
@RestController
@RequestMapping(value="/company/")
@Slf4j
@Api(value = "CompanyController", tags = {"公司模块"})
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @PostMapping("/findAll")
    @ApiOperation(value = "查找所有公司简略信息", notes = "查找所有公司简略信息")
    ResponseResult findAllCompany() {
        return companyService.findAll();
    }

    @PostMapping("/findCompanyById")
    @ApiOperation(value = "根据id查找公司信息", notes = "根据id查找公司信息")
    ResponseResult findCompanyById(@RequestBody String id) {
        return companyService.findCompanyById(id);
    }


    @PostMapping("/add")
    @ApiOperation(value = "添加公司", notes = "添加公司")
    ResponseResult addCompany(@RequestBody CompanyDto companyDto) {
        return companyService.addCompany(companyDto);
    }


    @PostMapping("/edit")
    @ApiOperation(value = "编辑公司", notes = "编辑公司")
    ResponseResult editCompany(@RequestBody EditCompanyDto editCompanyDto) {
        return companyService.editCompany(editCompanyDto);
    }

    @PostMapping("/findByUserId")
    @ApiOperation(value = "根据用户id查询公司", notes = "根据用户id查询公司")
    ResponseResult findCompanyByUserId(String userId) {
        return companyService.findCompanyByUserId(userId);
    }




}
