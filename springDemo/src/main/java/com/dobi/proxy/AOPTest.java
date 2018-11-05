package com.dobi.proxy;


import com.dobi.proxy.service.UserService;
import com.dobi.proxy.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *
 *  @描述：    TODO
 */
public class AOPTest {
    private static final String TAG = "AOPTest";

    public static void main(String [] args){


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //不能用实现类来接收，不然报错
//        UserServiceImpl us = (UserServiceImpl) context.getBean("us_aop");
        UserService us = (UserService) context.getBean("us_aop");
        //如果有配置了aop, 那么这里返回的就不是我们托管的那个UserServiceImpl的实例了。
        //而是它的代理实例
        System.out.println("us=" + us);


        us.save();

    }
}
