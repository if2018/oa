package com.example.oa.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class AccessRecord {

    //访问记录的ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //对应房产的ID
    private Integer houseId;
    //访问记录
    private String record;
    //回访人
    private String userName;
    //添加时间
    private Date setupTime;

    @Override
    public String toString() {
        return "AccessRecord{" +
                "id=" + id +
                ", houseId=" + houseId +
                ", record='" + record + '\'' +
                '}';
    }
}
