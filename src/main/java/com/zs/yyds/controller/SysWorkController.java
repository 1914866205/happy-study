package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CreateWorkDto;
import com.zs.yyds.modle.dto.DelWorkDto;
import com.zs.yyds.modle.dto.EditWorkDto;
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


    @ApiOperation(value = "获取所有的职位", notes = "获取所有的职位")
    @PostMapping("getAllWork")
    public ResponseResult getAllWork() {
        return sysWorkService.findAllType();
    }


    @ApiOperation(value = "添加职位", notes = "添加职位")
    @PostMapping("createWork")
    public ResponseResult createWork(@RequestBody CreateWorkDto work) {
        return sysWorkService.createWork(work);
    }

    @ApiOperation(value = "查找该用户发布的所有职位", notes = "查找该用户发布的所有职位")
    @PostMapping("findWorkByUserId")
    public ResponseResult findWorkByUserId(String userId) {
        return sysWorkService.findWorkByUserId(userId);
    }


    @ApiOperation(value = "删除自己发布的职位", notes = "删除自己发布的职位")
    @PostMapping("delWork")
    public ResponseResult delWork(@RequestBody DelWorkDto delWork) {
        return sysWorkService.delWork(delWork);
    }

    @ApiOperation(value = "修改自己发布过的职位", notes = "修改自己发布过的职位")
    @PostMapping("editWork")
    public ResponseResult editWork(@RequestBody EditWorkDto editWorkDto) {
        return sysWorkService.editWork(editWorkDto);
    }

    @ApiOperation(value = "根据工作名称查找相关工作", notes = "根据招聘工作id查询工作详情")
    @PostMapping("getWorkByName")
    public ResponseResult getWorkByName(String workName) {
        return sysWorkService.getWorkByName(workName);
    }

}

