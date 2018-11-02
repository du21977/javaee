package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *
 */
@RestController
public class TestController {
    private static final String TAG = "TestController";


    @RequestMapping("jqueryGet")
    public String jqueryGet(String username , String password){

        System.out.println("invoke jqueryGet="+username + " : "+ password);

        return "返回结果了";
    }

    @RequestMapping("jqueryPost")
    public String jqueryPost(String username , String password){

        System.out.println("invoke jqueryPost="+username + " : "+ password);

        return "返回结果了";
    }
}
