package com.dobi.aop.annotation.service.impl;


import com.dobi.aop.annotation.service.UserService;
import org.springframework.stereotype.Service;

/*
 *
 *  @描述：    TODO
 */

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl的save方法~!!!！");


        //Logger.log();
    }
}
