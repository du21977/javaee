package com.dobi.config;


import com.dobi.filter02.FilterDemo02;
import com.dobi.filter02.FilterDemo04;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *  自定义过滤器顺序
 */
//@Configuration
public class MyFilterConfig {
    private static final String TAG = "MyFilterConfig";

    //使用代码来配置filterDemo01  和 filterDemo04

    // 服务器会解析含有注解的方法，然后得到这个方法的返回值， 然后用bean02来标记它
    //相当于是以后服务器找到bean02 就能找到有关filterDemo02的一切配置信息
    @Bean("bean02")
    public FilterRegistrationBean registerFilter02(){

        //这个对象用于封装，要注册什么过滤器，过滤什么路径，过滤器的顺序位置，
        //都在这个对象里面指定
        FilterRegistrationBean bean02 = new FilterRegistrationBean();

        //要配置哪个过滤器
        bean02.setFilter(new FilterDemo02());

        //要过滤什么地址
        bean02.addUrlPatterns("/index11.html");

        //它的顺序是怎样？
        bean02.setOrder(22);

        return bean02;
    }

    @Bean("bean04")
    public FilterRegistrationBean registerFilter04(){

        //这个对象用于封装，要注册什么过滤器，过滤什么路径，过滤器的顺序位置，
        //都在这个对象里面指定
        FilterRegistrationBean bean04 = new FilterRegistrationBean();

        //要配置哪个过滤器
        bean04.setFilter(new FilterDemo04());

        //要过滤什么地址
        bean04.addUrlPatterns("/index11.html");

        //它的顺序是怎样？  谁的数字越小， 谁就排在前面。
        bean04.setOrder(4);

        return bean04;
    }
}
