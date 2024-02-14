package com.example.springaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/10 20:04
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/hi")
    public String sayhi(){
        System.out.println("hi");
        return "hi";
    }
}
