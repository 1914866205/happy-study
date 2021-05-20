package com.zs.yyds.repository;

import com.zs.yyds.modle.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CollectionRepository.java
 * @Description TODO
 * @createTime 2021年05月19日 21:09:00
 */
public interface CollectionRepository extends JpaRepository<Collection, String> {
    List<Collection> findCollectionsByUserIdEquals(String userId);
}
