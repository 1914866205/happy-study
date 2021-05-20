package com.zs.yyds.service;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CollectionDto;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CollectionService.java
 * @Description TODO
 * @createTime 2021年05月19日 21:10:00
 */
public interface CollectionService {
    ResponseResult addCollection(CollectionDto collectionDto);

    ResponseResult delCollection(String collectionId);

    ResponseResult findByUserId(String userId);
}
