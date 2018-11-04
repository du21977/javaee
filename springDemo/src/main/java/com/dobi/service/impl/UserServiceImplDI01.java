package com.dobi.service.impl;

import com.dobi.service.UserService;

/**
 * DI--依赖注入---xml--有参构造方式
 * 在实例化对象的时候对他里面的成员变量赋值
 *
 * 对这个address进行赋值的方式
 * 1.有参构造
 * 2.set方法
 * 3.反射
 *
 */
public class UserServiceImplDI01 implements UserService{

    private String address;

    public UserServiceImplDI01(String address) {
        this.address = address;
    }

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl-DI01的save方法-有参构造方式~~--"+address);
    }
}
