package com.dobi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 综合案例
 * 注册
 * 1.注册成功，跳转到注册成功页面，并显示昵称
 * 2.注册失败，跳到注册页面，并显示失败原因
 */
@Controller
public class HomeWorkContrller {


    @RequestMapping("/register11")
    public String register(String username, String password, Model model){
        System.out.println("进来注册啦");
        if(username.equals("admin")){
            model.addAttribute("result","用户名不可用");
            return "homework";
        }
        return "login.html";
    }


    /**
     * homework.html在templates下，不能直接访问，必须通过这种方式中转下
     * @return
     */
    @RequestMapping("/homework.html")
    public String toRegisterHtml(){

        System.out.println("---homework.html");
        return "homework";
    }

}
