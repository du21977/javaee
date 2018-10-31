package com.dobi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 页面跳转-----------有2种方式：请求转发和重定向
 */
//返回值看成字符串
//@RestController

//注解的中有很多注解，那这个注解称为元注解
//@Controller的返回值看成资源的名称
@Controller

//@ResponseBody 用于所有方法的返回值都是json字符串
//@ResponseBody
public class JumpCtroller {

    //////////////////////////////////////请求转发//////////////////////////////////////////////////
    //直接通过Controller----return就可以转发资源
    //这个是最简单的
    @RequestMapping("/testPage")
    public String testPage(){

        return "login.html";
    }

    //这是最明显的请求转发
    @RequestMapping("/testPage1")
    public String testPage1(){
        System.out.println("testPage1");
        return "forward:login.html";
    }

    //最原始的请求转发------借助request对象
    @RequestMapping("/forwardPage")
    public void forwardPage(HttpServletRequest request, HttpServletResponse response){

        System.out.println("forwardPage");
        try {
            request.getRequestDispatcher("login.html").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //不让他转发，让他返回字符串
    @RequestMapping("/testPage4")
    @ResponseBody
    public String testPage4(){
        System.out.println("testPage4");
        return "forward:login.html";
    }


    //////////////////////////////////////////////////重定向/////////////////////////////////////////////////////

    //重定向-------地址栏变成了return的地址
    @RequestMapping("/redirectPage1")
    public String redirectPage1(){
        System.out.println("redirectPage1");
        return "redirect:login.html";
    }

    //最原始的重定向------借助response对象
    @RequestMapping("/redirectPage2")
    public void redirectPage2(HttpServletRequest request, HttpServletResponse response){

        System.out.println("redirectPage2");
        try {
            response.sendRedirect("login.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
