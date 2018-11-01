package com.dobi.filter02;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
 *测试过滤器链
 */
@WebFilter("/*")
@Component
public class FilterDemo04 implements Filter {
    private static final String TAG = "FilterDemo04";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo04: init~!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo04: doFilter~1111!");

        //放行：如果后面还有过滤器，那么会执行过滤器， 如果都没有，会执行目标资源 controller | html
       chain.doFilter(request ,response);

        System.out.println("FilterDemo04: doFilter~2222!");
    }

    @Override
    public void destroy() {
        System.out.println("FilterDemo04: destroy~!");
    }
}
