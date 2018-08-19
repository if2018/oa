package com.example.oa.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class HouseSource {

    @Id
    //ID更新策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseId;
    //小区
    private String houseEstate;
    //房号
    private String houseNumber;
    //面积
    private BigDecimal houseSize;
    //总价
    private BigDecimal totalPrice;
    //其他备注，如朝向等
    private String houseRemark;
    //房东姓名
    private String landlordName;
    //房东电话
    private String landlordPhone;
    //经纪人姓名
    private String broker;
    //添加时间,该注解防止更新时，一同随着更新时间一同更新
    @Column(updatable = false)
    private Date setupTime;
    //更新时间
    private Date updateTime;



}
