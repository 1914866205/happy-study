package com.zs.yyds.modle.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Collection.java
 * @Description TODO
 * @createTime 2021年05月19日 20:52:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Collection {
    /**
     * 分类id
     */
    @Id
    private String pkCollectionId;

    /**
     * 用户id
     */
    @Column
    private String userId;

    /**
     * 职位id
     */
    @Column
    private String workId;

}