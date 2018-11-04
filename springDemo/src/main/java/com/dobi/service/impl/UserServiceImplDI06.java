package com.dobi.service.impl;

import com.dobi.dao.UserDao;
import com.dobi.dao.impl.UserDaoImpl;
import com.dobi.service.UserService;

import java.util.Map;

/**
 * DI--依赖注入---xml--set方式--对象注入
 * 在实例化对象的时候对他里面的成员变量赋值
 *
 * 对这个address进行赋值的方式
 * 1.有参构造
 * 2.set方法
 * 3.反射
 *
 */
public class UserServiceImplDI06 implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl-DI06--的save方法~~");
        //UserDao userDao = new UserDaoImpl();
        userDao.save();
    }
}
