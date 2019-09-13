package com.lee.phoenix.common.enums;

public enum AccountType {
    ADMIN(1, "admin"),
    USER(2, "user");


    private int value;
    private String desc;

    AccountType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static AccountType valueOf(int type) {
        switch (type) {
            case 1:
                return ADMIN;
            case 2:
                return USER;
            default:
                return USER;
        }
    }

    public int value() {
        return value;
    }

    public String toString() {
        return this.desc;
    }
}
