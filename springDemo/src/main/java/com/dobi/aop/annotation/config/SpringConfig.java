package com.dobi.aop.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.dobi.aop") //扫描包
@EnableAspectJAutoProxy
public class SpringConfig {

}
