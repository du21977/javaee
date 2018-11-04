package com.dobi.dao.impl;

import com.dobi.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("调用了UserDaoImpl的save方法~~");
    }
}
