package com.zs.yyds.service;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CreateWorkDto;
import com.zs.yyds.modle.dto.DelWorkDto;
import com.zs.yyds.modle.dto.EditWorkDto;
import com.zs.yyds.modle.dto.FindWorkDto;

import java.util.Map;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysWorkService.java
 * @Description TODO
 * @createTime 2021年04月20日 22:06:00
 */
public interface SysWorkService {
    /**
     * 根据工作类型id和招聘要求id查询在招职位
     * @param findWorkDto
     * @return
     */
    ResponseResult getAllWorkByTypeAndState(FindWorkDto findWorkDto);

    /**
     * 根据职位id找职位细节
     * @param workId
     * @return
     */
    ResponseResult getWorkById(String workId);

    /**
     * 查询所有的类型
     * @return
     */
    ResponseResult findAllType();


    /**
     * 创建职位
     * @param work
     * @return
     */
    ResponseResult createWork(CreateWorkDto work);

    /**
     * 查找该用户发布的所有职位
     * @param userId
     * @return
     */
    ResponseResult findWorkByUserId(String userId);

    /**
     * 删除自己发布的职位
     * @param delWork
     * @return
     */
    ResponseResult delWork(DelWorkDto delWork);

    /**
     * 修改自己发布过的职位
     * @param editWorkDto
     * @return
     */
    ResponseResult editWork(EditWorkDto editWorkDto);

    /**
     * 根据工作名称查找相关工作
     * @param workName
     * @return
     */
    ResponseResult getWorkByName(String workName);
}
