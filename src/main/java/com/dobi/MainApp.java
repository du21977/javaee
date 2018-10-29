package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//1.注解---启动类
//里面隐藏一层意思，它会扫描当前这个入口类所在包下面的所有子包
//搜罗出来所有带注解的类，才能认识controller
@SpringBootApplication
public class MainApp {


    //背后是启动了tomcat,然后部署了这个项目到tomcat里面去了
    public static void main(String[] args) {
        //让我们的项目运行起来
        SpringApplication.run(MainApp.class,args);
    }
}
