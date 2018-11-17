package com.dobi.allannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component("testImpl")
public class TestImpl {


    @Autowired
//    @Resource
    public    DataSource dataSource;


    public void  hah(){
        DataSource dataSource1 = dataSource;
    }
}
