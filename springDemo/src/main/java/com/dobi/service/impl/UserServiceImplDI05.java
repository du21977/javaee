package com.dobi.service.impl;

import com.dobi.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * DI--依赖注入---xml--set方式--map集合数据注入
 * 在实例化对象的时候对他里面的成员变量赋值
 *
 * 对这个address进行赋值的方式
 * 1.有参构造
 * 2.set方法
 * 3.反射
 *
 */
public class UserServiceImplDI05 implements UserService{

    private Map<String,String> address;

    public void setAddress(Map<String,String> address) {
        this.address = address;
    }

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl-DI04--的save方法~~--set方式--map"+ address);
    }
}
