package com.dobi.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//表示过滤哪些请求，貌似在这里都拦截，要想过滤，得去配置，见MyFilterConfig，或者本例下面判断路径也行
//@WebFilter("/*") //表示根目录下的东西都过滤

//告诉Spring，这个类是一个组件，需要把这个类的实例创建出来
//@Component
public class FilterDemo  implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //服务器启动的时候执行，只执行一次
        System.out.println("init");
    }

    //基本上都在这个方法操作
    //来一次请求执行一次
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");

        //这句话表示，不拦截，放行
//        chain.doFilter(request,response);

        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpServletRequest request1 = (HttpServletRequest) request;
        String requestURI = request1.getRequestURI();
        System.out.println(requestURI);
        if(requestURI.contains("login")){
            chain.doFilter(request,response);
        }

        //com.dobi.controller
        if(requestURI.contains("filtertest")){
            chain.doFilter(request,response);
        }
        System.out.println("放行后执行");

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
