package com.example.controlleradvice.common;

import lombok.Data;

/**
 * @author 陈孟飞
 * @date 2020/6/22
 */
@Data
public class R {
    private boolean success;
    private Object data;
    private String message;
    private Integer code;

    private static Integer TRUE_CODE = 10000;
    private static Integer FALSE_CODE = 99999;
    public static R data(Object obj){
        R r = new R();
        r.setData(obj);
        r.setSuccess(true);
        r.setCode(TRUE_CODE);
        return r;
    }

    public static R error(Integer code, String message){
        R r = new R();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static R error(String message){
        int code = TRUE_CODE;
        return R.error(code, message);
    }
}
