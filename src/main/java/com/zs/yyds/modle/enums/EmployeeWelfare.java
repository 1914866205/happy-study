package com.zs.yyds.modle.enums;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName EmployeeWelfare.java
 * @Description TODO
 * @createTime 2021年05月04日 21:32:00
 */
public enum EmployeeWelfare {

    /**
     * 员工福利枚举
     * 五险一金 补充医疗保险 定期体检 年终奖 股票期权 带薪年假 员工旅游 免费班车 餐补 通讯补贴  交通补贴 节日福利 住房补贴 零食下午茶
     */
    A("五险一金"),
    B("补充医疗保险"),
    C("定期体检"),
    D("年终奖"),
    E("股票期权"),
    F("带薪年假"),
    G("股票期权"),
    H("员工旅游"),
    I("免费班车"),
    J("餐补"),
    K("通讯补贴"),
    L("交通补贴"),
    M("节日福利"),
    N("住房补贴"),
    O("零食下午茶");

    private String employeeWelfareName;

    EmployeeWelfare(String employeeWelfareName) {
        this.employeeWelfareName = employeeWelfareName;
    }

    public static String employeeWelfareName(String employeeWelfareName) {
        for (EmployeeWelfare item : EmployeeWelfare.values()) {
            if (item.name().equals(employeeWelfareName)) {
                return item.employeeWelfareName;
            }
        }
        return employeeWelfareName;
    }


    public String employeeWelfareName() {
        return this.employeeWelfareName;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
