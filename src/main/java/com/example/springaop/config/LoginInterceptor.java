package com.example.springaop.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/10 21:19
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return true表示验证成功，可以继续执行后续流程
     * false表示验证失败，后面流程不执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession(false);
        if (session!=null&&session.getAttribute("userinfo")!=null){
            return true;
        }
//        可以跳到登陆页面或返回401/403没有权限
        response.sendRedirect("/login.html");
        return false;
    }
}
