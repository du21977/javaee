package com.dobi.filter02;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
    测试过滤器链
 */


//@WebFilter("/*")
//@Component
public class FilterDemo02 implements Filter {
    private static final String TAG = "FilterDemo02";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo02: init~!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo02: doFilter~1111!");

        chain.doFilter(request ,response);

        System.out.println("FilterDemo02: doFilter~2222!");
    }

    @Override
    public void destroy() {
        System.out.println("FilterDemo02: destroy~!");
    }
}
