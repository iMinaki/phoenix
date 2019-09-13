package com.lee.phoenix.service;

import com.lee.phoenix.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User findByUsernameOrPhone(String phone);
}
