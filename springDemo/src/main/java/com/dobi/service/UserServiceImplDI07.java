package com.dobi.service;

import com.dobi.dao.UserDao;
import com.dobi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * DI--依赖注入---注解方式--对象注入
 * 在实例化对象的时候对他里面的成员变量赋值
 *
 * 对这个address进行赋值的方式
 * 1.有参构造
 * 2.set方法
 * 3.反射
 *
 */
@Service("userServiceImplDI07")
public class UserServiceImplDI07 implements UserService{

    @Resource(name = "userDaoImpl02") //根据给定的标识符找到对应的实例对象，然后赋值给userDao
//    @Autowired  //自动注入 ，根据最终要求找到对应的实现对象，然后注入进来，--只能有一种实现的，不然报错
    private UserDao userDao;



    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl-DI07--的save方法~~");
        //UserDao userDao = new UserDaoImpl();
        userDao.save();
    }
}
