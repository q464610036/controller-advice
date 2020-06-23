package com.example.controlleradvice.exception;

import com.example.controlleradvice.common.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 陈孟飞
 * @date 2020/6/22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler() //无异常类型
    @ResponseBody
    R handleException(Exception e){
        return R.error(e.getMessage());
    }

    @ExceptionHandler(MyException.class) //有异常类型
    @ResponseBody
    R handleException(MyException e){
        System.out.println("自定义异常特殊逻辑...");
        return R.error(e.getMessage());
    }
}
