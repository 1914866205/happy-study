package com.zs.yyds.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreeNode {
    private String pkMenuId;

    private String parentId;

    private String typeName;

    private String typeUrl;

    private List<TreeNode> subMenus;

    public TreeNode(String pkMenuId, String parentId, String typeName, String typeUrl) {
        this.pkMenuId = pkMenuId;
        this.parentId = parentId;
        this.typeName = typeName;
        this.typeUrl = typeUrl;
    }
}
