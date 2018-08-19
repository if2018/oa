package com.example.oa.service;

import com.example.oa.bean.User;

import java.util.List;

public interface UserService {

    User findOne(Integer userId);

    List<User> findAll();

    User save(User user);

    User findByUserName(String userName);
}
