package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 */
@SpringBootApplication
public class MainApp {
    private static final String TAG = "MainApp";

    public static void main(String [] args){
        SpringApplication.run(MainApp.class , args) ;
    }
}
