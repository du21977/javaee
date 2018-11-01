package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *
 */
@SpringBootApplication
public class JsonApp {
    private static final String TAG = "JsonApp";
    
    public static void main(String [] args){
        SpringApplication.run(JsonApp.class , args);     
    }
}
