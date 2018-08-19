package com.example.oa.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 返回JSON的格式
 */
@Data
public class AccessRecordVO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("houseId")
    //对应房产的ID
    private Integer houseId;
    //访问记录
    @JsonProperty("record")
    private String record;
    //添加时间
    @JsonProperty("setupTime")
    private Date setupTime;
    @JsonProperty("userName")
    //回访人
    private String userName;

}
