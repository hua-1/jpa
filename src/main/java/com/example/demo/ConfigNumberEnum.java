package com.example.demo;

public enum ConfigNumberEnum {
    MONEY_MIX(0.1,"人数分配最小比例"),
    MONEY_MAX(20.0,"最小红包钱数"),
    PLATFORM_RATE(0.15,"平台抽成"),
    ENDPROPORTION(0.85,"抽成之后的比例"),
    ROBPROPORTION(0.035,"抢红包积分比例"),
    SENDPROPORTION(0.025,"发红包积分比例"),
    INTEGRAL(1000.0,"积分兑换"),
    SIXTY(0.6,"新拉比例"),
    TWENTY(0.2,"普通用户"),
    TEN(0.1,"vip用户"),
    ;
    // 成员变量
    public Double index;
    public String name;


    ConfigNumberEnum(Double index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Double getIndex(int index) {
        for (ConfigNumberEnum identityEnum : ConfigNumberEnum.values()) {
            if (identityEnum.getIndex().equals(index)){
                return identityEnum.getIndex();
            }
        }
        return null;
    }

    public Double getIndex() {
        return index;
    }

    public void setIndex(Double index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
