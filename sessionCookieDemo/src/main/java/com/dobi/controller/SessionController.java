package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {


    @RequestMapping("/testSession")
    public String sessionTest(HttpServletRequest request){

        //1.获取session session其实就是内存中的一块区域
        //只要有这句话，就是说只要产生了session空间，服务器就会自动把sessionid加到cookie中去
        //session自动失效时间默认为30分钟
        HttpSession session = request.getSession();

        //2.获取sessionId-----不关浏览器，sessionid是一样的
        String id = session.getId();
        System.out.println(id);

        //存值
        session.setAttribute("address","china");
        String address = (String) session.getAttribute("address");
        System.out.println("取值="+address);

//        //移除属性
//        session.removeAttribute("address");
//
//        //销毁session
//        session.invalidate();
//        System.out.println();

        return "success";
    }
}
