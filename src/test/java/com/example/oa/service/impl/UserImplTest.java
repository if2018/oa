package com.example.oa.service.impl;

import com.example.oa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findOne() {
        System.out.println(userService.findOne(1));
    }

    @Test
    public void findAll() {
        System.out.println(userService.findAll());
    }

    @Test
    public void save() {
    }
}