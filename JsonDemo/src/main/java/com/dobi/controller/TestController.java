package com.dobi.controller;

import com.dobi.bean.Student;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



//@Restcon  @ResponseBody   就是表示了指定的方法返回值会变成json字符串。 Spring MVC 框架
@RestController  //= @Controller  +@ResponseBody

public class TestController {
    private static final String TAG = "TestController";
    
    public static void main(String [] args){

        Student stu = new Student(1,"zhangsan",18);

        //对象 ---》 json
        Gson gson = new Gson();
        String json = gson.toJson(stu);
        System.out.println("json=" + json);


        //json ---> 对象

        Student student = gson.fromJson(json ,Student.class);
        System.out.println("student=" + student);
    }


    @RequestMapping("testJson")
    public Student testJson(){
        Student stu = new Student(2,"zhangsan2",28);
        return stu;
    }


    @RequestMapping("testJson2")
    public List<Student> testJson2(){

        List<Student> list = new ArrayList<Student>();
        list.add(new Student(2,"zhangsan2",28));
        list.add(new Student(3,"zhangsan3",38));
        list.add(new Student(4,"zhangsan4",48));
        list.add(new Student(5,"zhangsan5",58));

        return list;
    }

}
