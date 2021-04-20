package com.zs.yyds.service.impl;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.FindWorkDto;
import com.zs.yyds.modle.entity.SysUser;
import com.zs.yyds.modle.entity.SysWork;
import com.zs.yyds.modle.vo.PublisherVo;
import com.zs.yyds.modle.vo.WorkListVo;
import com.zs.yyds.repository.SysUserRepository;
import com.zs.yyds.repository.SysWorkRepository;
import com.zs.yyds.service.SysWorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
