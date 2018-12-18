package com.example.demo;

public enum IdentityEnum {
    NEW_USER(1, "拉新用户"),
    NONMAL(2, "普通用户"),
    VIP(3, "会员"),
    AGENT(4, "代理");

    // 成员变量
    public Integer index;
    public String name;

    IdentityEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Integer getIdentity(int index) {
        for (IdentityEnum identityEnum : IdentityEnum.values()) {
            if (identityEnum.getIndex().equals(index)){
                return identityEnum.getIndex();
            }
        }
        return null;
    }
    public static IdentityEnum get(int index) {
        for (IdentityEnum identityEnum : IdentityEnum.values()) {
            if (identityEnum.getIndex().equals(index)){
                return identityEnum;
            }
        }
        return null;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
