package com.dobi.test;


import com.dobi.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试spring 的环境
 */
public class TestSpring {

    @Test
    public void run1(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        // 调用方法
        as.findAll();
    }

}
