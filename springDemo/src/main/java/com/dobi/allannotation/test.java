package com.dobi.allannotation;

import com.dobi.allannotation.config.JdbcConfig;
import com.dobi.proxy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * debug测试纯注解
 */
public class test {


    public static void main(String[] args) {

        //通过注解获取容器---纯注解，没有xml文件
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

//        DataSource dataSource1 = (DataSource) ac.getBean("dataSourceDataSource");//这个有数据
        TestImpl testImpl = (TestImpl) ac.getBean("testImpl");
        DataSource dataSource1 = testImpl.dataSource;
        int a =5;


    }


}
