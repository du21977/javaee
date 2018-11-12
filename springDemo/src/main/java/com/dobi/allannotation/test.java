package com.dobi.allannotation;

import com.dobi.allannotation.config.JdbcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

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
