package com.dobi.service.impl;

import com.dobi.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * DI--依赖注入---xml--set方式--list集合数据注入
 * 在实例化对象的时候对他里面的成员变量赋值
 *
 * 对这个address进行赋值的方式
 * 1.有参构造
 * 2.set方法
 * 3.反射
 *
 */
public class UserServiceImplDI04 implements UserService{

    private List<String> address;

    public void setAddress(List<String> address) {
        this.address = address;
    }

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl-DI03--的save方法~~--set方式--list"+ address);
    }
}
