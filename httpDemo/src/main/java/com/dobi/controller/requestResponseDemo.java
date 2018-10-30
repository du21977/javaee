package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@RestController
public class requestResponseDemo {



    @RequestMapping("/requestDemo")
    public String requestDemo(HttpServletRequest request){

        String username = request.getParameter("username");

        System.out.println("username"+username);

        //获取所有的头信息，这是一个枚举集合
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            //头名字
            String headName = headerNames.nextElement();
            //头对应的值
            String headValue = request.getHeader(headName);

            System.out.println(headName +":"+headValue);
        }

        return "request success";
    }

    /**
     * 响应-----给浏览器写数据
     * @param response
     * @return
     */
    @RequestMapping("/responseDemo")
    public void responseDemo(HttpServletResponse response){

        System.out.println("responseDemo");
        try {
            //设置中文--响应头有这个字段，表示返回数据的类型
            response.setContentType("text/html;charset=utf-8");
            //向浏览器写数据
            response.getWriter().write("写数据啦");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //其实页面跳转也是由resqust和response来做的

        //这个return返回值，给浏览器带数据，这一行的背后就是使用response对象写出去的
        //return "response success";
    }
}
