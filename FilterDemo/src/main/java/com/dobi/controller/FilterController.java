package com.dobi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @RequestMapping("/filtertest")
    public String test(){

        System.out.println("filtertest---");
        return "sussess--";
    }
}
