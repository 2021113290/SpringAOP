package com.example.springaop.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/14 18:24
 */
@ControllerAdvice
public class ResAdvice implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;
    /**
     *
     * @param returnType
     * @param converterType
     * @return 返回true执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        HashMap<String,Object> result=new HashMap<>();
        result.put("code",200);
        result.put("msg","");
        result.put("data",body);
        if (body instanceof String){
            try {
                return objectMapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
