package com.dobi;

import com.dobi.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//1.表示这个类是一个控制器，需要打上注解
@RestController
public class DemoController {

    //2.表示浏览器的什么地址，才能对应上这个方法
    //请求映射
    @RequestMapping("/save")
    private void save(){
        System.out.println("调用了save方法");
    }

    @RequestMapping("/update")
    private String update(){
        System.out.println("调用了update方法");
        return "haha";
    }

    ////////////////////////////////////////////华丽的分割线//////////////////////////////////////////////////////
    //SpringMVC带参请求可以看下面文章
    //https://www.cnblogs.com/xiaoxi/p/5695783.html
    //下面是访问带参的地址
    @RequestMapping("/register")
    private String register(String username ,String password){
        System.out.println("调用了register方法--"+username +":"+password);
        return "register";
    }


    //下面是访问带参的地址 ----get请求
    @RequestMapping(value = "/register1",method = RequestMethod.GET)
    private String register1(String username ,String password){
        System.out.println("调用了register1方法--"+username +":"+password);
        return "register1";
    }

    //下面是访问带参的地址 ----post请求
    @RequestMapping(value = "/register2",method = RequestMethod.POST)
    private String register2(String username ,String password){
        System.out.println("调用了register2方法--"+username +":"+password);
        return "register2";
    }

    //下面是访问带参的地址 ----post和get请求都可以
    @RequestMapping(value = "/register3",method = RequestMethod.POST)
    private String register3(@RequestParam("username") String username , @RequestParam("password") String password){
        System.out.println("调用了register3方法--"+username +":"+password);
        return "register3";
    }


    //访问带参的地址-------post和get请求都可以
    @RequestMapping("/register4")
    private String register4(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("调用了register4方法--"+username +":"+password);
        return "register4";
    }

    //参数太多了怎么办，用对象装，对象多了，用集合装
    //访问带参的地址-------post和get请求都可以
    @RequestMapping("/register5")
    private String register5(User user){
        System.out.println("调用了register5方法--"+user);
        return user.toString();
    }


}
