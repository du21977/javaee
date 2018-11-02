package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *
 *  @描述：    TODO
 */
@RestController
public class TestController {
    private static final String TAG = "TestController";

    @RequestMapping("ajaxGet")
    public String ajaxGet(){

        System.out.println("invoke~!~ajaxGet--du");

        return "get success-du";
    }

    @RequestMapping("ajaxPost")
    public String ajaxPost(String username , String password){

        System.out.println("invoke~!~ajaxPost="+username+":"+password);

        return "post success-du";
    }


}
