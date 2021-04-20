package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.FindWorkDto;
import com.zs.yyds.service.SysWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysWorkController.java
 * @Description TODO
 * @createTime 2021年04月20日 22:04:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/work/")
@Api(value = "SysWorkController", tags = {"工作模块"})
public class SysWorkController {
    @Resource
    private SysWorkService sysWorkService;

    @ApiOperation(value = "根据工作类型，工作状态查询在招职位", notes = "根据工作类型，工作状态查询在招职位")
    @PostMapping("getWork")
    public ResponseResult getAllWorkByTypeAndState(@RequestBody FindWorkDto findWorkDto) {
        return sysWorkService.getAllWorkByTypeAndState(findWorkDto);
    }

    @ApiOperation(value = "根据招聘工作id查询工作详情", notes = "根据招聘工作id查询工作详情")
    @PostMapping("getWorkById")
    public ResponseResult getWorkById(String workId) {
        return sysWorkService.getWorkById(workId);
    }




}
