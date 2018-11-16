package com.dobi.dao.impl;

import com.dobi.dao.UserDao;

/**
 * 这个是使用xml实例化
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("调用了UserDaoImpl的save方法~~");
    }


}
