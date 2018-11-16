package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {


    /**
     * 给session内存空间存值
     * @param request
     * @return
     */
    @RequestMapping("/testSession")
    public String sessionTest(HttpServletRequest request){

        //1.获取session session其实就是内存中的一块区域
        //只要有这句话，就是说只要产生了session空间，服务器就会自动把sessionid加到cookie中去
        //session自动失效时间默认为30分钟
        HttpSession session = request.getSession();

        //2.获取sessionId-----不关浏览器，sessionid是一样的
        String id = session.getId();
        System.out.println(id);
        session.setMaxInactiveInterval(60*60*2); //session2小时过期，默认是30分钟

        //存值
        session.setAttribute("userName","du21977");
        String userName = (String) session.getAttribute("userName");
//        System.out.println("取值="+userName);

//        //移除属性
//        session.removeAttribute("address");
//
//        //销毁session
//        session.invalidate();
//        System.out.println();

        return "success";
    }


    /**
     * 从session空间中取值
     * @param request
     * @return
     */
    @RequestMapping("/testSession1")
    public String sessionTest1(HttpServletRequest request){

        //1.获取session session其实就是内存中的一块区域
        //只要有这句话，就是说只要产生了session空间，服务器就会自动把sessionid加到cookie中去
        //session自动失效时间默认为30分钟
        HttpSession session = request.getSession();

        //2.获取sessionId-----不关浏览器，sessionid是一样的
        String id = session.getId();
        System.out.println(id);

        //存值
//        session.setAttribute("address","china");
        String userName = (String) session.getAttribute("userName");
        System.out.println("取值="+userName);

//        //移除属性
//        session.removeAttribute("address");
//
//        //销毁session
//        session.invalidate();
//        System.out.println();

        return "success";
    }
}
