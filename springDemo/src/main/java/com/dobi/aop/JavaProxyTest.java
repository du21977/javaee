package com.dobi.aop;



import com.dobi.aop.service.UserService;
import com.dobi.aop.service.impl.UserServiceImpl;
import com.dobi.aop.util.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 *  java sdk上自带的动态代理
 *  @描述：    TODO
 */
public class JavaProxyTest {
    private static final String TAG = "JavaProxyTest";

    public static void main(String [] args){
        /*UserService userService = new UserServiceImpl();
        userService.save();*/

/*
        //1 创建真实对象-----被代理对象
        UserService userService = new UserServiceImpl();

        //2. 创建代理对象
        UserService  proxyObj  = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Logger.log();

                        return method.invoke( userService, args);
                    }
                }
        );*/


        /*UserService userService = new UserServiceImpl();
        userService.save();*/


        UserService proxyObj = getProxy();
        proxyObj.save();

    }


    public static UserService  getProxy(){
        //1 创建真实对象----被代理对象
        UserService userService = new UserServiceImpl();

        //2. 创建代理对象
        UserService  proxyObj  = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Logger.log();
                        System.out.println("动态代理拦截");
                        Object result =  method.invoke( userService, args);
                        Logger.log();
                        return result;
                    }
                }
        );

        //返回代理对象
        return proxyObj;
    }
}
