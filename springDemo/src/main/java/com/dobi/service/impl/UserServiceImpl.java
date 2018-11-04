package com.dobi.service.impl;

import com.dobi.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl的save方法~~");
    }

}
