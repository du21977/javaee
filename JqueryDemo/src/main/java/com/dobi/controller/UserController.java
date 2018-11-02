package com.dobi.controller;

/*
 *
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final String TAG = "UserController";

    @RequestMapping("checkUserName")
    public String checkUserName(String username){

        System.out.println("checkUsername=" + username);

        if("admin".equals(username)){
            return "use";
        }
        return "nouse";
    }
}
