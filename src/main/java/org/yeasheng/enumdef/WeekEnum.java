package org.yeasheng.enumdef;

/**
 * @author yansh
 * @version 2021/7/3
 **/
public enum WeekEnum {

    MONDAY("星期一", 1),
    TUESDAY("星期二", 2),
    WEDNESDAY("星期三", 3),
    THURSDAY("星期四", 4),
    FRIDAY("星期五", 5),
    SATURDAY("星期六", 6),
    SUNDAY("星期日", 7);

    private String value;

    private Integer code;

    WeekEnum(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return this.value;
    }

    public Integer getCode() {
        return this.code;
    }
}
