package com.example.oa.myEnum;


import lombok.Getter;

@Getter
public enum  ErrorCode {

    ID_NULL("01","参数异常");


    private String code;
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
