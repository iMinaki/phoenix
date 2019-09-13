package com.lee.phoenix.service;

import com.lee.phoenix.entity.User;
import com.lee.phoenix.repo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsernameOrPhone(String username) {
        return userRepository.findByUsernameOrPhone(username);
    }

}