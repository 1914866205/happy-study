package com.zs.yyds.modle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CollectionDto.java
 * @Description TODO
 * @createTime 2021年05月19日 21:13:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CollectionDto {
    private String userId;
    private String workId;

}
