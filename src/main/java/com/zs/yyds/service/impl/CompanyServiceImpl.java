package com.zs.yyds.service.impl;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.common.ResultCode;
import com.zs.yyds.modle.dto.CompanyDto;
import com.zs.yyds.modle.dto.EditCompanyDto;
import com.zs.yyds.modle.entity.Company;
import com.zs.yyds.modle.entity.SysWork;
import com.zs.yyds.modle.enums.CompanyType;
import com.zs.yyds.modle.vo.CompanyVo;
import com.zs.yyds.modle.vo.WorkVo;
import com.zs.yyds.repository.CompanyRepository;
import com.zs.yyds.repository.SysWorkRepository;
import com.zs.yyds.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CompanyServiceImpl.java
 * @Description TODO
 * @createTime 2021年05月05日 07:33:00
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyRepository companyRepository;
    @Resource
    private SysWorkRepository sysWorkRepository;

    @Override
    public ResponseResult findAll() {
        List<Company> companies = companyRepository.findAll();
        System.out.println("companies_________________" + companies);
        List<CompanyVo> companyVoList = new ArrayList<>();
        for (Company company : companies) {
            System.out.println("company_________________" + company);
            CompanyVo companyVo = new CompanyVo();
            companyVo.setCompanyId(company.getPkCompanyId());
            companyVo.setCompanyName(company.getCompanyName());
            companyVo.setCompanyType(company.getCompanyType());
            companyVo.setIsSmart(company.getIsMarketing());
            companyVo.setAvatarUrl(company.getAvatarUrl());
            companyVo.setScale(company.getScale());
            List<WorkVo> list = new ArrayList<>();
            String[] workIds = company.getPkWorkId().trim().split("--");
            for (int i = 0; i < workIds.length; i++) {
                System.out.println("workIds["+i+"]"+workIds[i]);
                if (!"".equals(workIds[i])) {
                    SysWork sysWork = sysWorkRepository.getOne(workIds[i]);
                    WorkVo workVo = new WorkVo();
                    workVo.setWorkId(sysWork.getPkWorkId());
                    workVo.setAddress(sysWork.getWorkCity());
                    workVo.setWorkName(sysWork.getPositionName());
                    workVo.setWorkExperience(sysWork.getWorkExperience());
                    workVo.setStudyExperience(sysWork.getQualification());
                    workVo.setStartMoney(String.valueOf(sysWork.getStartMoney()));
                    workVo.setEndMoney(String.valueOf(sysWork.getEndMoney()));
                    System.out.println("workVo_________________" + workVo);
                    list.add(workVo);
                }
            }
            companyVo.setWorkVoList(list);
            companyVoList.add(companyVo);
            System.out.println("companyVo_________________" + companyVo);
        }
            System.out.println("companyVoList_________________" + companyVoList);
        return ResponseResult.success(companyVoList);
    }

    @Override
    public ResponseResult findCompanyById(String id) {
        return ResponseResult.success(companyRepository.findById(id).get());
    }

    @Override
    public ResponseResult addCompany(CompanyDto companyDto) {
        List<Company> companies = companyRepository.findCompanyByCompanyNameEquals(companyDto.getCompanyName());
        int size = companies.size();
        if (size != 0) {
            return ResponseResult.failure(ResultCode.DATA_ALREADY_EXISTED, "该公司已被注册");
        }
        Company company = Company.builder()
                .pkCompanyId(UUID.randomUUID().toString().substring(0, 15))
                .addresses(companyDto.getAddresses())
                .avatarUrl(companyDto.getAvatarUrl())
                .companyName(companyDto.getCompanyName())
                .bossName(companyDto.getBossName())
                .businessInformation(companyDto.getBusinessInformation())
                .createdTime(Timestamp.valueOf(LocalDateTime.now()))
                .freeTime(companyDto.getFreeTime())
                .isMarketing(companyDto.getIsMarketing())
                .introduction(companyDto.getIntroduction())
                .marketTime(companyDto.getMarketTime())
                .pkUserId(companyDto.getPkUserId())
                .pkWorkId(companyDto.getPkWorkId())
                .registerMoney(companyDto.getRegisterMoney())
                .workTime(companyDto.getWorkTime())
                .companyType(companyDto.getCompanyType())
                .employeeWelfare(companyDto.getEmployeeWelfare())
                .scale(companyDto.getScale())
                .album(companyDto.getAlbum())
                .build();
        companyRepository.save(company);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult editCompany(EditCompanyDto editCompanyDto) {
        Company old = companyRepository.getOne(editCompanyDto.getPkCompanyId());
        Company company = Company.builder()
                .pkCompanyId(editCompanyDto.getPkCompanyId())
                .addresses(editCompanyDto.getAddresses())
                .avatarUrl(editCompanyDto.getAvatarUrl())
                .companyName(editCompanyDto.getCompanyName())
                .bossName(editCompanyDto.getBossName())
                .businessInformation(editCompanyDto.getBusinessInformation())
                .createdTime(Timestamp.valueOf(LocalDateTime.now()))
                .freeTime(editCompanyDto.getFreeTime())
                .isMarketing(editCompanyDto.getIsMarketing())
                .introduction(editCompanyDto.getIntroduction())
                .marketTime(editCompanyDto.getMarketTime())
                .pkUserId(editCompanyDto.getPkUserId())
                .pkWorkId(editCompanyDto.getPkWorkId())
                .registerMoney(editCompanyDto.getRegisterMoney())
                .workTime(editCompanyDto.getWorkTime())
                .companyType(editCompanyDto.getCompanyType())
                .employeeWelfare(editCompanyDto.getEmployeeWelfare())
                .scale(editCompanyDto.getScale())
                .album(editCompanyDto.getAlbum())
                .createdTime(old.getCreatedTime())
                .build();

        companyRepository.save(company);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult findCompanyByUserId(String userId) {
        List<Company> company = companyRepository.findCompanyByPkUserIdEquals(userId);
        if (company.size() == 0) {
            return ResponseResult.success("无公司");
        }
        return ResponseResult.success(company.get(0));
    }
}
