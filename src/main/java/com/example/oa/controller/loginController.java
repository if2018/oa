package com.example.oa.controller;


import com.example.oa.service.UserService;
import com.example.oa.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity//注解开启springSecurity的功能
public class loginController extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user1")
//                .password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
//        //在内存中创建一个用户，该用户名称为user，密码为123456，角色为USER
//        //auth.userDetailsService();
//    }
    @Bean
    public UserDetailsService customUserService() {
        return new MyUserDetailServiceImpl();
    }
    // BrowerSecurityConfig加密方式
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new MessageDigestPasswordEncoder("MD5"));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//定义哪些url需要保护，哪些url不需要保护
        .antMatchers("/css/**","/js/**","/img/**","/bootstrap-4.0.0/**","/common/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
        .formLogin()
                .loginPage("/login") //定义当需要登录时跳转到登录页面
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/logout")
                .permitAll();
                //csrf不能禁用，否则logout页面无法访问
//                .and()
//                .csrf().disable();

    }



}
