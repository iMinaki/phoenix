package com.lee.phoenix.contract.auth;

import com.lee.phoenix.common.validator.ValidPhone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TLogin {
    @NotEmpty(message = "用户名不能为空！")
    private String username;

    @NotEmpty(message = "密码不能为空！")
    @Size(max = 20, min = 6, message = "密码长度为6-20位")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}