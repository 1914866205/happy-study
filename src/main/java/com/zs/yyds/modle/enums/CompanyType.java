package com.zs.yyds.modle.enums;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName CompanyType.java
 * @Description TODO
 * @createTime 2021年05月04日 21:32:00
 */
public enum CompanyType {
    /**
     * 公司类型
     */
    A("科技类"),
    B("文化、传媒广告类"),
    C("咨询类"),
    D("管理类"),
    E("商贸类");

    private String companyTypeName;

    CompanyType(String CompanyTypeName) {
        this.companyTypeName = CompanyTypeName;
    }

    public static String CompanyTypeName(String CompanyTypeName) {
        for (CompanyType item : CompanyType.values()) {
            if (item.name().equals(CompanyTypeName)) {
                return item.companyTypeName;
            }
        }
        return CompanyTypeName;
    }


    public String companyTypeName() {
        return this.companyTypeName;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public static void main(String[] args) {
        System.out.println(CompanyType.CompanyTypeName("科技类"));
    }
}
