package com.example.oa.service.impl;


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
//加密方式
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {



        com.example.oa.bean.User user=userService.findByUserName(s);
        //System.out.println(user.getPassword());

        //User u = new User(user.getName(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        return user;
    }
}
