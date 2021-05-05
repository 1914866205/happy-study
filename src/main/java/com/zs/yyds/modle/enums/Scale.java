package com.zs.yyds.modle.enums;

import com.zs.yyds.common.ResultCode;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Scale.java
 * @Description TODO
 * @createTime 2021年05月04日 21:32:00
 */
public enum Scale {
    /**
     * 公司规模枚举
     * 1 20以下
     * 2 21-50
     * 3 51-100
     * 4 101-500
     * 5 501-1000
     * 6 1001-5000
     * 7 5001-10000
     * 8 10000以上
     */
    D("20以下"),
    C("21-50"),
    B("51-100"),
    A("101-1000"),
    S("1001-5000"),
    SS("5001-10000"),
    SSS("10000以上");

    private String scaleName;

    Scale(String scaleName) {
        this.scaleName = scaleName;
    }

    public static String scaleName(String name) {
        for (Scale item : Scale.values()) {
            if (item.name().equals(name)) {
                return item.scaleName;
            }
        }
        return name;
    }


    public String scaleName() {
        return this.scaleName;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
