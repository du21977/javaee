package com.dobi.controller;

import org.springframework.web.bind.annotation.*;

/*
 *
 */
@RestController
public class DemoController {
    private static final String TAG = "DemoController";


    //@RequestMapping(value = "/user" , method = RequestMethod.POST)

//    @GetMapping       查
//    @PutMapping       改
//    @DeleteMapping    删
//    @PostMapping      增

    @PostMapping("/user")
    public String save(String username , String password){
        System.out.println("调用了save方法~！" + username + " : "+ password);
        return "save success";
    }
}
