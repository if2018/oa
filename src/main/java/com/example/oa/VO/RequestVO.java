package com.example.oa.VO;

import lombok.Data;

/**
 * 返回数据类型
 */
@Data
public class RequestVO<T> {

    //错误码
    private Integer code;
    //错误信息
    private String msg;
    //返回数据
    private T data;
}
