package com.dobi.aop.annotation;

import com.dobi.allannotation.config.JdbcConfig;
import com.dobi.aop.annotation.config.SpringConfig;
import com.dobi.aop.annotation.service.UserService;
import com.dobi.aop.annotation.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于纯注解方式的AOP
 */
public class AOPTest {

    public static void main(String[] args) {
        //通过注解获取容器---纯注解，没有xml文件
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        //此处要是接口，不能是实现类
        UserService userServiceImpl = (UserService) ac.getBean("userServiceImpl");
        //调用方法，动态代理类调用了环绕通知
        userServiceImpl.save();
    }

}
