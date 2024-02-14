package com.example.springaop.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/14 17:43
 */
@ControllerAdvice
@ResponseBody
public class myExceptionHandler {
    /**
     * 拦截空指针异常，统一数据返回
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public HashMap<String, Object> nullExp(NullPointerException e){
    HashMap<String,Object> result=new HashMap<>();
    result.put("code","-1");
    result.put("message","空指针异常 "+e.getMessage());//错误码的描述信息
    result.put("data",null);
    return result;
}
    @ExceptionHandler(ArithmeticException.class)
    public HashMap<String, Object> AriExp(ArithmeticException e){
    HashMap<String,Object> result=new HashMap<>();
    result.put("code","-2");
    result.put("message","算数异常 "+e.getMessage());//错误码的描述信息
    result.put("data",null);
    return result;
}
    @ExceptionHandler(Exception.class)
    public Object exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-3");
        result.put("message", "总的异常信息：" + e.getMessage());
        result.put("data", null);
        return result;
    }

}
