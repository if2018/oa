package com.example.oa.exception;

import com.example.oa.myEnum.ErrorCode;

public class BusinessException extends RuntimeException{

    public BusinessException(ErrorCode idNull) {
        super();
    }

    public BusinessException(String code) {
        super(code);
    }
}
