package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User login(User user);

    boolean validatePhone(String phone);

    boolean signin(User user);
}
