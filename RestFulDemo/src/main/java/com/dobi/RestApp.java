package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *
 */
@SpringBootApplication
public class RestApp {
    private static final String TAG = "com.dobi.RestApp";

    public static void main(String [] args){
        SpringApplication.run(RestApp.class , args) ;
    }
}
