package com.example.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xinyu
 * @version 1.0
 * @description: User切面
 * @date 2024/2/10 19:59
 */
@Aspect//表示为一个切面类
@Component//随着项目的启动而启动
public class UserAspect {


    /**
     *    拦截UserController的所有方法
     *    切点（配置拦截规则）
     */
    @Pointcut("execution(* com.example.springaop.controller.UserController.*(..))")
    public void pointcut(){

    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void beforeAdvice(){
        System.out.println("执行前置通知");
    }

    /**
     * 后置通知
     */
    @After("pointcut()")
    public void AfterAdvice(){
        System.out.println("执行后置通知");
    }
    /**
     * 环绕通知
     */
    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入环绕通知");
        Object object=null;
//        执行目标方法
        object=joinPoint.proceed();
        System.out.println("退出环绕通知");
        return object;
    }


}
