package com.zs.yyds.service.impl;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CollectionDto;
import com.zs.yyds.modle.entity.Collection;
import com.zs.yyds.repository.CollectionRepository;
import com.zs.yyds.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CollectionServiceImpl.java
 * @Description TODO
 * @createTime 2021年05月19日 21:10:00
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionRepository collectionRepository;

    @Override
    public ResponseResult addCollection(CollectionDto collectionDto) {
        Collection collection = Collection.builder()
                .pkCollectionId(UUID.randomUUID().toString().substring(0, 15))
                .workId(collectionDto.getWorkId())
                .userId(collectionDto.getUserId())
                .build();
        collectionRepository.save(collection);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult delCollection(String collectionId) {
        collectionRepository.deleteById(collectionId);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult findByUserId(String userId) {
        List<Collection> collections = collectionRepository.findCollectionsByUserIdEquals(userId);
        return ResponseResult.success(collections);
    }
}
