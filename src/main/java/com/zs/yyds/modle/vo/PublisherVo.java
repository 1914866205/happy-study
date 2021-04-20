package com.zs.yyds.modle.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Publisher.java
 * @Description TODO
 * @createTime 2021年04月20日 22:43:00
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class PublisherVo {
    private String avatarUrl;
    private String userName;
    private String position;
}
