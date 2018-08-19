package com.example.oa.service.impl;

import com.example.oa.bean.User;
import com.example.oa.dao.UserDao;
import com.example.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User findOne(Integer userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
