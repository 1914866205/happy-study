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
 * @ClassName WorkType.java
 * @Description TODO
 * @createTime 2021年04月15日 00:53:00
 */

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class WorkType {
    /**
     * 分类id
     */
    @Id
    private String pkWorkTypeId;

    /**
     * 父级id
     */
    @Column
    private String parentId;

    /**
     * 类型名称
     */
    @Column
    private String typeName;

    /**
     * 路径
     */
    @Column
    private String typeUrl;
}
