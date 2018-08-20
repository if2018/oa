package com.example.oa.bean;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@DynamicUpdate
@Data
public class User implements UserDetails {

    //用户id
    @Id
    private Integer userId;
    //用户姓名
    private String userName;
    //用户密码
    private String password;
    //用户电话
    private String phone;
    //用户头像
    private String icon;
    //用户权限1为管理员0为普通用户
    private Integer admin;
    //经纪人姓名
    private String name;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(this.getAdmin() == 1){
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
            GrantedAuthority au = new SimpleGrantedAuthority("ROLE_ADMIN");
            list.add(au);
            return list;

        }
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
