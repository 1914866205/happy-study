package com.zs.yyds.repository;

import com.zs.yyds.modle.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName SysUserRepository.java
 * @Description TODO
 * @createTime 2021年04月15日 01:00:00
 */

//云琪保管
public interface CompanyRepository extends JpaRepository<Company, String> {
    List<Company> findCompanyByCompanyNameEquals(String companyName);

    List<Company> findCompanyByPkUserIdEquals(String userId);
}
