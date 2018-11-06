package com.dobi.allannotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Spring1中都是用xml来创建对象
 Spring2中基本用xml和注解结合来创建对象，通过xml来设置扫描有注解的类
 通过反射来创建对象
 Spring3完全用注解来代替xml了
 1.@Configuration:声明一个类作为配置类，代替xml
 2.@Bean:声明在方法上，将方法的返回值加入Bean容器，代替<bean>标签
 3.@Value:属性注入
 4.@PropertySource:指定外部属性文件
 */


@Configuration //把他当成一个xml来看了
@ComponentScan("com.dobi") //扫描包
@PropertySource("classpath:jdbc.properties")  //读取属性文件
public class JdbcConfig {

    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean("dataSourceDataSource")  //这个就相当于new对象啦，相当于之前xml文件中的<bean>标签
    public DataSource dataSource(){
        //阿里巴巴的数据库连接池
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return  druidDataSource;
    }

}
