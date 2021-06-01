package com.zs.yyds.repository;

import com.zs.yyds.modle.entity.SysWork;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysWorkRepository.java
 * @Description TODO
 * @createTime 2021年04月20日 22:07:00
 */
public interface SysWorkRepository extends JpaRepository<SysWork, String> {
    /**
     * 根据工作类型，工作状态查询在招职位
     * @param pkWorkTypeId
     * @param workStatus
     * @param status
     * @return
     */
    List<SysWork> findSysWorksByPkWorkTypeIdAndWorkStatusAndStatusEquals(String pkWorkTypeId, int workStatus, int status);

    /**
     * 查找该用户发布的所有职位
     * @param userId
     * @return
     */
    List<SysWork> findSysWorksByPkUserIdEquals(String userId);

    /**
     * 根据工作名称查找类似工作
     * @param workName
     * @return
     */
    List<SysWork> findSysWorkByPositionNameIsLike(String workName);

}
