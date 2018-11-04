package com.dobi;

import com.dobi.service.UserService;
import com.dobi.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        //我们自己的写法
//        UserService userService = new UserServiceImpl();
//        userService.save();

        //Spring写法
        //1.创建工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.问工厂要实例
        UserService userService = (UserService) context.getBean("us");
        //3.调用方法
        userService.save();
    }

}
