package com.example.oa.util;

import com.example.oa.VO.RequestVO;

/**
 * 返回JSON附带格式
 */
public class RequestVOUtil {
    public static RequestVO success(Object object){
        RequestVO requestVO=new RequestVO();
        requestVO.setCode(0);
        requestVO.setMsg("成功");
        requestVO.setData(object);
        return requestVO;
    }
    public static RequestVO success(){
        return success(null);
    }

    public static RequestVO error(Integer code,String msg){
        RequestVO resultVO=new RequestVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
