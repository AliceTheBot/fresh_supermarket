package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.findByPhoneAndUpassword(user.getPhone(),user.getUpassword());
    }

    @Override
    public boolean validatePhone(String phone) {
        return userDao.countAllByPhone(phone)==0;
    }

    @Override
    public boolean signin(User user) {
        return userDao.save(user).getId()>0;
    }
}
