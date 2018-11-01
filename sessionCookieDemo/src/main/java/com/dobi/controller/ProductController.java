package com.dobi.controller;


import com.dobi.bean.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/*
 *  @项目名：  day03 
 *  @包名：    com.itheima.controller
 *  @文件名:   ProductController
 *  @创建者:   xiaomi
 *  @创建时间:  2018/6/2 11:56
 *  @描述：    TODO
 */
@Controller
public class ProductController {
    private static final String TAG = "ProductController";


    public static void main(String [] args){

        Map<String , String> map = new HashMap<String ,String>();

        map.put("aa","aa1");
        map.put("bb","bb1");
        map.put("cc","cc1");

        Set<String> keySet = map.keySet();

        for(String key: keySet){
            String value = map.get(key);

            System.out.println(key + " : " + value);
        }


        Set<Map.Entry<String, String>> entries = map.entrySet();

        for(Map.Entry<String , String >  en :entries){

            System.out.println(en.getKey() + " : " + en.getValue());


        }
    }


    private static  List<Product> list = new ArrayList<Product>();

    //只会执行一次，当类的字节码被加载到JVM的时候，只会执行一次。
    static{
        list.add(new Product(1,"小米5",1999));   //1
        list.add(new Product(2,"海尔冰箱",2999)); //2
        list.add(new Product(3,"vivo8",3999)); //3
        list.add(new Product(4,"iphon9",6999));
        list.add(new Product(5,"联想鼠标垫",50));
    }

    //显示商品列表
    @RequestMapping("listProduct")
    public String listProduct(Model model){

        //1. 准备商品

        //2. 存商品
        model.addAttribute("list" , list);

        //3. 到list页面显示商品
        return "list";
    }


    //添加商品到购物车中，要给过来商品的编号
    @RequestMapping("addToCart")
    public String addToCart(HttpServletRequest request , HttpServletResponse response, int id){

        System.out.println("id=" + id);

        HttpSession session = request.getSession();

        //1. 获取商品对象
        Product product = list.get(id-1);

        //2. 存储到购物车
        Map<Product , Integer> map = (Map<Product, Integer>) session.getAttribute("cartMap");
        if(map == null){
            map = new HashMap<Product , Integer>();
        }


        if(map.containsKey(product)){
            //有这件商品  原来的数量 + 1
            map.put(product , map.get(product)+1);
        }else{
            //没有这件商品 ， 数量=1
            map.put(product , 1);
        }


        //3. 把购物车存到session里面去。
        session.setAttribute("cartMap",map);

        System.out.println("添加购物车完毕，要跳转到中转页面了~");


        //4. 为了让购物车存在的更长久一点，现在要手动设置cookie
        Cookie cookie = new Cookie("JSESSIONID" , session.getId());

        cookie.setMaxAge(60*60*24*7);

        response.addCookie(cookie);

        //4. 跳转页面  当前的请求是从模板页面发送出来的，所以这里也认为是跑到模板页面去了。
        return "redirect:transfer.html";
        //return "forward:transfer.html";
    }


    //跳转到购物车的页面
    @RequestMapping("toCart")
    public String toCart(){

        return "cart";
    }

}
