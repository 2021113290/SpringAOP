package com.example.springaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/10 21:02
 */
@RestController
@RequestMapping("/user2")
public class UserController2 {
    @RequestMapping("/getnum")
    public Integer getNumber(){
        return new Random().nextInt(10);
    }
    @RequestMapping("/getuser")
    public String getUser(){
        System.out.println("执行get user");
        return "执行get user";
    }
    @RequestMapping("/login")
    public String login(){
//        Object obj=null;
//        obj.hashCode();//空指针异常
        System.out.println("执行login");
        return "执行login";
    }
    @RequestMapping("/reg")
    public String reg(){
//        int num=10/0;
        System.out.println("执行reg");
        return "执行reg";
    }
}
