package com.zs.yyds.controller;

import com.zs.yyds.common.ResponseResult;
import com.zs.yyds.modle.dto.CollectionDto;
import com.zs.yyds.modle.entity.Collection;
import com.zs.yyds.service.CollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CollectionController.java
 * @Description TODO
 * @createTime 2021年05月19日 21:11:00
 */
@RestController
@RequestMapping(value = "/collection/")
@Slf4j
@Api(value = "CollectionController", tags = {"收藏模块"})
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @PostMapping("/add")
    @ApiOperation(value = "添加收藏", notes = "添加收藏")
    ResponseResult addCollection(@RequestBody CollectionDto collectionDto) {
        return collectionService.addCollection(collectionDto);
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除收藏", notes = "删除收藏")
    ResponseResult delCollection(String collectionId) {
        return collectionService.delCollection(collectionId);
    }

    @PostMapping("/findByUserId")
    @ApiOperation(value = "查找用户所有收藏", notes = "查找用户所有收藏")
    ResponseResult findByUserId(String userId) {
        return collectionService.findByUserId(userId);
    }
}
