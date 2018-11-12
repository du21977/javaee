package com.dobi.aop.service.impl;


import com.dobi.aop.service.UserService;

/*
 *
 *  @描述：    TODO
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl的save方法~!!!！");


        //Logger.log();
    }
}
