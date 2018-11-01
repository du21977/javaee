package com.dobi.autologin.controller;


import com.dobi.autologin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 *
 */
@Controller
public class UserController {
    private static final String TAG = "UserController";

    @RequestMapping("user_login")
    public String login(User user , String auto , HttpSession session , HttpServletResponse response){

        if("admin".equals(user.getUsername()) && "123".equals(user.getPassword()) ){
            //登录成功

            //存值 model  & session
            session.setAttribute("user",user);


            //判断是否有勾选自动登录.
            if("on".equals(auto)){

                System.out.println("有勾选自动登录");

                Cookie cookie = new Cookie("account",user.getUsername()+"#"+user.getPassword());

                cookie.setMaxAge(60*60*24*7);

                response.addCookie(cookie);
            }

            //跳转
            return "index";
        }

        //存数据
        session.setAttribute("msg","用户名或者密码错误!");

        //跳转到登录页面，显示数据
        return "login";
    }

    @RequestMapping("showLogin")
    public String showLogin(){

        return "login";
    }

    @RequestMapping("showIndex")
    public String showIndex(){

        return "index";
    }
}
