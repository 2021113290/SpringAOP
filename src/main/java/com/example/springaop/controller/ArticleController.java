package com.example.springaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/10 20:09
 */
@RestController
@RequestMapping("/art")
public class ArticleController {
    @RequestMapping("/hi")
    public String sayhi(){
        System.out.println("hi");
        return "hi";
    }
}
