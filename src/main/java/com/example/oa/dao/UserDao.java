package com.example.oa.dao;

import com.example.oa.bean.User;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUserId(Integer userId);

    User findByUserName(String userName);
}
