package com.example.demo;

public enum IdentityEnum {
    NEW_USER(4, "NEW_USER","拉新用户"),
    NONMAL(3, "NONMAL","普通用户"),
    VIP(2, "VIP","vip用户"),
    AGENT(1, "AGENT","代理");

    // 成员变量
    public Integer index;
    public String name;
    public String identity;
    IdentityEnum(Integer index, String name,String identity) {
        this.index = index;
        this.name = name;
        this.identity=identity;
    }

    public static Integer getIdentity(int index) {
        for (IdentityEnum identityEnum : IdentityEnum.values()) {
            if (identityEnum.getIndex().equals(index)){
                return identityEnum.getIndex();
            }
        }
        return null;
    }
    public static String get(int index) {
        for (IdentityEnum identityEnum : IdentityEnum.values()) {
            if (identityEnum.getIndex().equals(index)){
                return identityEnum.getName();
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
