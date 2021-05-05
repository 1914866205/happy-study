package com.zs.yyds;

import com.zs.yyds.repository.SysWorkRepository;
import com.zs.yyds.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RecruitApplicationTests {
    @Resource
    private CompanyService companyService;
    @Test
    void contextLoads() {
        System.out.println(companyService.findCompanyById("06923e36-179c-4"));
    }

}
