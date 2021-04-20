package com.zs.yyds;

import com.zs.yyds.repository.SysWorkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RecruitApplicationTests {
    @Resource
    private SysWorkRepository sysWorkRepository;
    @Test
    void contextLoads() {
        System.out.println(sysWorkRepository.findSysWorksByPkWorkTypeIdAndWorkStatusAndStatusEquals("3", 1, 1));
    }

}
