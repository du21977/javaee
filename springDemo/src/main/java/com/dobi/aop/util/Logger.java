package com.dobi.aop.util;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 *
 *  @描述：    TODO
 */
public class Logger {
    private static final String TAG = "Logger";

    public static void log(){
        System.out.println("输出日志~");
    }

    //AOP环绕增强用的
    //joinPoint 参数其实就是我们的目标对象
    public void around(ProceedingJoinPoint joinPoint){

        try {
            log();
            joinPoint.proceed(); //调用了目标方法其实就相当于 xxx.save();
            log();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
