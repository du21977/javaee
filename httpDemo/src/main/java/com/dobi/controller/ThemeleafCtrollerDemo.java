package com.dobi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Thymeleaf是SpringBoot推荐的view模板----显示动态数据
 * 跳转的页面要在资源中的templates中
 * html中要引入命名空间xmlns:th="http://www.thymeleaf.org">
 */
@Controller
public class ThemeleafCtrollerDemo {

    @RequestMapping("/themeleaf_login")
    public String login(String username, String password, Model model){

        //通过model把数据存进内存
        model.addAttribute("nickname",username);
        //居然不能写return "index.html";
        return "index";
    }


    @RequestMapping("/themeleaf1")
    public String themeleaf1(String username, String password, Model model){

        //通过model把数据存进内存
        model.addAttribute("address","广州市");
        //居然不能写return "testpage.html";
        return "testpage";
    }


    /**
     * 存数据还有一个Modle
     * @return
     */
    @RequestMapping("/themeleaf2")
    public ModelAndView themeleaf2(){

        ModelAndView modelAndView = new ModelAndView();
        //存数据
        modelAndView.addObject("address","北京");

        //2.指定视图
        modelAndView.setViewName("testpage");

        return modelAndView;
    }
}
