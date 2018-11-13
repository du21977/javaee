package com.dobi.service;

import com.dobi.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 使用注解的方式完成IOC，没有id的方式
 */

/**
 * @Component是通用的注解，但是随着时间的推移，代码会分层来写
 * 所以Spring 针对三层的类也提供了各自的注解
 *
 * web----@Controller
 * service---@Service
 * dao-----@Repository
 *
 * 默认是单例模式，想要多例，就使用这个注解
 * @Scope("prototype") //多例
 *
 *如果托管了某个一个类，但是没有写id标识符，那么默认是什么呢
 * 默认是类名，但是第一个字母小写
 * UserServiceImpl03----》userServiceImpl03
 *
 *
 */


//@Component("us02") //组件，只要打上这个注解，就相当于告诉spring要创建这个类的实例
@Service
@Scope("prototype") //多例
public class UserServiceImpl03 implements UserService {

    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl-03的save方法~~");
    }

}
