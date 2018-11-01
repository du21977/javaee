package com.dobi.controller;

/*
 */



import org.springframework.web.bind.annotation.*;
import com.dobi.bean.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class StudentController {
    private static final String TAG = "StudentController";


    private Map<Integer , Student> map = new HashMap<Integer, Student>();


    @PostMapping("/student")
    public String save(Student student){

        System.out.println("stu=" + student);

        map.put(map.size() + 1 , student);

        return "save success";
    }


    //localhost:8080/user?id=1;

    //"message": "Missing URI template variable 'id' for method parameter of type int",
    //localhost:8080/user/1


    /*
        由于删除或者更新的时候，带过来的数据，一般是id值，都会在地址上面拼接，再也不会像以前一样。通过
        参数的形式传递过来。这就要求，我们必须获取到地址上的id值。

        地址：比如：localhost:8080/user/1

        1.  指定映射的时候。  @DeleteMapping("/user/{id}")

        2. 在方法上指定参数，参数的名字必须是上面{}里面的单词， 而且要记得加上注解 @PathVariable

        @PathVariable url绑定占位符

         @DeleteMapping("/user/{id}")
         public String delete(@PathVariable int id){
     */


    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable int id){
        System.out.println("id=" + id);

        map.remove(id);

        //遍历看一看
        Set<Integer> keySet = map.keySet();
        for(int key :keySet){
            System.out.println(key + " = " + map.get(key));
        }
        return "delete success";
    }



    // localhost:8080/student/1

    @PutMapping("/student/{id}")
    public String update(@PathVariable int id , Student student){

        map.put(id , student);


        Set<Integer> keySet = map.keySet();
        for(int key :keySet){
            System.out.println(key + " = " + map.get(key));
        }

        return "update success";
    }


    @GetMapping("/student")
    public String list(){

        Set<Integer> keySet = map.keySet();
        for(int key :keySet){
            System.out.println(key + " = " + map.get(key));
        }
        return "list success";
    }


    @GetMapping("/student/{id}")
    public String findStudentById(@PathVariable int id){


        System.out.println(id + " : " + map.get(id));


        return "list success";
    }



}
