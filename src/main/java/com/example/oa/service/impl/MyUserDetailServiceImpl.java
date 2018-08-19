package com.example.oa.service.impl;

import com.example.oa.bean.User;
import com.example.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * 用户名密码查询
 */
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {



        User user=userService.findByUserName(s);
        //System.out.println(user.getPassword());
        return user;
    }
}
