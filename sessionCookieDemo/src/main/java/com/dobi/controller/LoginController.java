package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    /**
     * 把当前时间戳存到cookie中
     * @param username
     * @param password
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletResponse response,HttpServletRequest request){

        if(username.equals("admin")&&password.equals("123")){

            Cookie[] cookies = request.getCookies();
            //第一次是没有cookie的
            if (cookies!=null){
                for (Cookie cookie: cookies) {
                    String cookieName = cookie.getName();

                    if(cookieName.equals("last")){
                        String cookieValue = cookie.getValue();//上次登录时间拿到了
                    }
                }
            }


            //获取时间戳，存到Cookie
            Cookie cookie = new Cookie("last",System.currentTimeMillis()+"");
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
        }
        return "";
    }
}
