package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByPhoneAndUpassword(String phone, String upassword);

    Integer countAllByPhone(String phone);

    User findByPhone(String Phone);
}
