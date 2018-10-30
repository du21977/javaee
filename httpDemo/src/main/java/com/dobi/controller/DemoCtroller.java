package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCtroller {

    @RequestMapping("/doGet")
    public String doGet(String username,String password){

        System.out.println("请求成功--"+username+":"+password);
        return "请求成功";
    }

    @RequestMapping("/doPost")
    public String doPost(String username,String password){

        System.out.println("请求成功--"+username+":"+password);
        return "请求成功";
    }



}
