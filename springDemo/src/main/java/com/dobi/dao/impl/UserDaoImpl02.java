package com.dobi.dao.impl;

import com.dobi.dao.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 使用注解方式实例化
 */
@Repository("userDaoImpl02")
public class UserDaoImpl02 implements UserDao {

    @Override
    public void save() {
        System.out.println("调用了UserDaoImpl的save方法~~");
    }
}
