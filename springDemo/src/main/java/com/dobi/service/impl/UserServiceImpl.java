package com.dobi.service.impl;

import com.dobi.service.UserService;

/**
 * IOC(控制反转)的xml方式
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl的save方法~~");
    }

}
