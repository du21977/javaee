package com.dobi.autologin.filter;


import com.dobi.autologin.bean.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 *
 */

@WebFilter("/*")
@Component
@Order
public class LoginFilter implements Filter {
    private static final String TAG = "LoginFilter";



    //最终的目标是： 如果有登录了，就放行，没有登录，就去登录页面登录。
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("来到过滤器了。~！~开始拦截请求");

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;

        //如果现在是有关登录操作的，就不要拦截了。
        String path = req.getRequestURI();
        System.out.println("path=" + path);
        if(path.contains("login") || path.contains("Login")){

            //放行
            chain.doFilter(request,response);

            return ;
        }

        boolean  isLogin = false;


        //1. 会话还有效，
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        if(user != null){

            isLogin = true;
            //会话有效
           // chain.doFilter(request , response);
        }else{
            //会话失效，就得看cookie了。
            //1. 获取cookie
            //2. 遍历cookie
            //3. 拿到账号密码，然后判断
            //4. 如果对了，就放行，还要把用户对象存储到session里面。？

            Cookie[] cookies = req.getCookies();
            if(cookies != null){
                for(Cookie cookie:cookies){

                    // account=admin#123;
                    if("account".equals(cookie.getName())){
                        String [] accountArray = cookie.getValue().split("#");

                        //判定账号和密码
                        if("admin".equals(accountArray[0]) && "123".equals(accountArray[1])){

                            //登录成功.
                            //1. 存用户对象到session里面去，以便在会话有效期内访问，都会放行。
                            user = new User(accountArray[0], accountArray[1]);
                            req.getSession().setAttribute("user" , user);

                            //chain.doFilter(request,response);

                            isLogin =true;
                        }
                    }

                }
            }

        }


        //统一对isLogin判定
        if(isLogin){
            chain.doFilter(request,response);
        }else{
            resp.sendRedirect("showLogin");
        }



        //2. 会话过期。


       // chain.doFilter(request , response);
    }




    //============================================================


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void destroy() {

    }
}
