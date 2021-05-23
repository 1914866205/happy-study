package com.zs.yyds.service.impl;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CreateWorkDto;
import com.zs.yyds.modle.dto.DelWorkDto;
import com.zs.yyds.modle.dto.EditWorkDto;
import com.zs.yyds.modle.dto.FindWorkDto;
import com.zs.yyds.modle.entity.SysUser;
import com.zs.yyds.modle.entity.SysWork;
import com.zs.yyds.modle.entity.WorkType;
import com.zs.yyds.modle.vo.PublisherVo;
import com.zs.yyds.modle.vo.WorkListVo;
import com.zs.yyds.repository.SysUserRepository;
import com.zs.yyds.repository.SysWorkRepository;
import com.zs.yyds.repository.WorkTypeRepository;
import com.zs.yyds.service.SysWorkService;
import com.zs.yyds.utils.TreeBuilder;
import com.zs.yyds.utils.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysWorkServiceImpl.java
 * @Description TODO
 * @createTime 2021年04月20日 22:06:00
 */
@Slf4j
@Service
public class SysWorkServiceImpl implements SysWorkService {
    @Resource
    private SysWorkRepository sysWorkRepository;
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private WorkTypeRepository workTypeRepository;

    @Override
    public ResponseResult getAllWorkByTypeAndState(FindWorkDto findWorkDto) {
        List<SysWork> works = sysWorkRepository.findSysWorksByPkWorkTypeIdAndWorkStatusAndStatusEquals(findWorkDto.getPkWorkTypeId(), findWorkDto.getWorkStatus(), 1);
        List<WorkListVo> workListVos = new ArrayList<>();
        for (SysWork work : works) {
            SysUser sysUser = sysUserRepository.findById(work.getPkUserId()).get();
            workListVos.add(
                    WorkListVo.builder()
                            .pkWorkId(work.getPkWorkId())
                            .positionName(work.getPositionName())
                            .startMoney(work.getStartMoney())
                            .endMoney(work.getEndMoney())
                            .workMonths(work.getWorkMonths())
                            .workCity(work.getWorkCity())
                            .qualification(work.getQualification())
                            .publisherVo(
                                    PublisherVo.builder()
                                            .avatarUrl(sysUser.getAvatarUrl())
                                            .position(work.getPosition())
                                            .userName(sysUser.getName())
                                            .build()
                            ).company(work.getCompany())
                            .pkWorkTypeId(work.getPkWorkTypeId())
                            .positionName(work.getPositionName())
                            .workStatus(1)
                            .build()
            );
        }
        return ResponseResult.success(workListVos);
    }

    @Override
    public ResponseResult getWorkById(String workId) {
        return ResponseResult.success(sysWorkRepository.findById(workId).get());
    }

    @Override
    public ResponseResult findAllType() {
        Map<String, Object> map = new TreeMap<>();
        List<TreeNode> list = new ArrayList<>();
        //查找所有的type
        List<WorkType> types = workTypeRepository.findAll();
        for (WorkType workType : types) {
            //如果没有父节点
            if (workType.getParentId().equals("0")) {
                TreeNode treeNode = new TreeNode(workType.getPkWorkTypeId(), "0", workType.getTypeName(), workType.getTypeUrl(), new ArrayList<>());
                list.add(treeNode);
            } else {
                TreeNode treeNode = new TreeNode(workType.getPkWorkTypeId(), workType.getParentId(), workType.getTypeName(), workType.getTypeUrl(), new ArrayList<>());
                list.add(treeNode);
            }
        }
        List<TreeNode> trees = TreeBuilder.buildTreeByLoop(list);
        map.put("types", trees);
        return ResponseResult.success(map);
    }

    @Override
    public ResponseResult createWork(CreateWorkDto work) {

        SysWork sysWork = SysWork.builder()
                .pkWorkId(UUID.randomUUID().toString().substring(0, 15))
                .createdTime(Timestamp.valueOf(LocalDateTime.now()))
                .positionName(work.getPositionName())
                .startMoney(work.getStartMoney())
                .endMoney(work.getEndMoney())
                .workMonths(work.getWorkMonths())
                .workCity(work.getWorkCity())
                .workExperience(work.getWorkExperience())
                .qualification(work.getQualification())
                .pkUserId(work.getPkUserId())
                .company(work.getCompany())
                .position(work.getPosition())
                .workDetails(work.getWorkDetails())
                .workNeed(work.getWorkNeed())
                .pkWorkTypeId(work.getPkWorkTypeId())
                .status(work.getStatus())
                .workStatus(work.getWorkStatus())
                .build();
        sysWorkRepository.save(sysWork);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult findWorkByUserId(String userId) {
        List<SysWork> works = sysWorkRepository.findSysWorksByPkUserIdEquals(userId);
        return ResponseResult.success(works);
    }

    @Override
    public ResponseResult delWork(DelWorkDto delWork) {
        SysWork sysWork = sysWorkRepository.getOne(delWork.getPkWorkId());
        if (delWork.getPkUserId().equals(sysWork.getPkUserId())) {
            sysWorkRepository.delete(sysWork);
        }
        return ResponseResult.success();
    }

    @Override
    public ResponseResult editWork(EditWorkDto editWorkDto) {
        SysWork sysWork = sysWorkRepository.getOne(editWorkDto.getPkWorkId());
        if (sysWork != null && sysWork.getPkUserId().equals(editWorkDto.getPkUserId())) {
            SysWork newWork = SysWork.builder()
                    .pkWorkId(sysWork.getPkWorkId())
                    .createdTime(sysWork.getCreatedTime())
                    .pkUserId(sysWork.getPkUserId())
                    .positionName(editWorkDto.getPositionName())
                    .startMoney(editWorkDto.getStartMoney())
                    .endMoney(editWorkDto.getEndMoney())
                    .workMonths(editWorkDto.getWorkMonths())
                    .workCity(editWorkDto.getWorkCity())
                    .workExperience(editWorkDto.getWorkExperience())
                    .qualification(editWorkDto.getQualification())
                    .company(editWorkDto.getCompany())
                    .position(editWorkDto.getPosition())
                    .workDetails(editWorkDto.getWorkDetails())
                    .workNeed(editWorkDto.getWorkNeed())
                    .pkWorkTypeId(editWorkDto.getPkWorkTypeId())
                    .status(editWorkDto.getStatus())
                    .workStatus(editWorkDto.getWorkStatus())
                    .build();
            sysWorkRepository.save(newWork);
        }

        return ResponseResult.success();
    }

    @Override
    public ResponseResult getWorkByName(String workName) {
        List<SysWork> work = sysWorkRepository.findSysWorkByPositionNameIsLike("%" + workName + "%");
        return ResponseResult.success(work);
    }
}
