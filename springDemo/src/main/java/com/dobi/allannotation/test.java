package com.dobi.allannotation;

import com.dobi.allannotation.config.JdbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class test {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {

        //通过注解获取容器---纯注解，没有xml文件
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        DataSource dataSource1 = (DataSource) ac.getBean("dataSourceDataSource");//这个有数据
//        DataSource dataSource1 = new test().dataSource;//这个居然么数据
        int a =5;


    }
}
