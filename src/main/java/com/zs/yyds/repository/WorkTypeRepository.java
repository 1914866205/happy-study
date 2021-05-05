package com.zs.yyds.repository;

import com.zs.yyds.modle.entity.SysWork;
import com.zs.yyds.modle.entity.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName WorkTypeRepository.java
 * @Description TODO
 * @createTime 2021年04月30日 16:07:00
 */
public interface WorkTypeRepository extends JpaRepository<WorkType, String> {

}
