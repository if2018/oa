package com.example.oa.VO;

import com.example.oa.bean.AccessRecord;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * http请求返回给前端的参数
 * 房产信息，全部
 */
@Data
public class HouseSourceVO {
    //id

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
    //访问记录

    private List<AccessRecordVO> accessRecords;

    private Date setupTime;
    //更新时间
    private Date updateTime;
}
