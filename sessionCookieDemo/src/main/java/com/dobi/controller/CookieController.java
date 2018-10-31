package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieController {

    @RequestMapping("/test")
    public String test(HttpServletResponse response){
        System.out.println("----");

        //默认是临时性的cooie，关闭浏览器，cookie消失
        Cookie cookie = new Cookie("aaa","bbb");
        Cookie cookie1 = new Cookie("111","222");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        return "chengg";
    }


    @RequestMapping("/test2")
    public String test2(HttpServletResponse response){
        System.out.println("----");

        //默认是临时性的cooie，关闭浏览器，cookie消失
        Cookie cookie = new Cookie("aaa","duchengwen---");
        //默认为-1，负数关闭浏览器就失效
        cookie.setMaxAge(60*60*24*7); //7天

        response.addCookie(cookie);

        return "chengg";
    }

}
