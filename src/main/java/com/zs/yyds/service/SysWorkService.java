package com.zs.yyds.service;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.FindWorkDto;

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
}
