package com.dobi.aop.annotation.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 *
 *  @描述：    TODO
 */
@Component("logger")
@Aspect //表明这是一个切面类
public class Logger {
    private static final String TAG = "Logger";

    //前置通知
//    @Before("execution(* com.dobi.aop.annotation.service.impl.*.*(..))")
    public static void logBefore(){
        System.out.println("前置输出日志~");
    }

    //后置通知
//    @AfterReturning("execution(* com.dobi.aop.annotation.service.impl.*.*(..))")
    public static void logAfterReturning(){
        System.out.println("后置输出日志~");
    }

    //AOP环绕增强用的
    //joinPoint 参数其实就是我们的目标对象
    //环绕通知
    @Around("execution(* com.dobi.aop.annotation.service.impl.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint){

        try {
            //
            logBefore();
            joinPoint.proceed(); //调用了目标方法其实就相当于 xxx.save();
            logAfterReturning();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
