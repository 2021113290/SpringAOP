package com.example.springaop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/10 21:30
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有请求
                .excludePathPatterns("/user2/login")//不拦截的url地址
                .excludePathPatterns("/user2/reg")
                .excludePathPatterns("/user2/getnum")
                .excludePathPatterns("/**/*.html");
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("/xy",c->true);
//    }
}
