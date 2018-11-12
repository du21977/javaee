package com.dobi.aop;


import com.dobi.aop.service.impl.ProductService;
import com.dobi.aop.util.Logger;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
 *  cglib动态代理
 *  @创建时间:  2018/6/12 12:11
 *  @描述：    TODO
 */
public class CglibTest {
    private static final String TAG = "CglibTest";

    public static void main(String [] args){
       /* ProductService ps = new ProductService();
        ps.save();*/

       ProductService ps = getProxy();
       ps.save();
    }

    //创建ProductService的代理
    public static ProductService getProxy(){

        //1. 真实对象 ---被代理对象
        ProductService ps = new ProductService();

        //2. 创建代理---代理对象
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(ProductService.class);

        //回调方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("让代理对象干活了");

                //代理的意思其实就相当于我们拿到了目标方法的执行权，我们可以选择先执行扩展的功能，再执行本来的功能
                Logger.log();

                return method.invoke(ps , objects);
            }
        });
        //返回代理对象
        return (ProductService) enhancer.create();
    }
}
