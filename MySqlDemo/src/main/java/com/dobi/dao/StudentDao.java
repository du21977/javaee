package com.dobi.dao;



import com.dobi.bean.Student;

import java.util.List;

/*
 *
 *  @描述：    接口是用来声明一套标准，一种规范，里面的方法都是抽象方法。
 */
public interface StudentDao {


    //增加
    //void save(String name , int age);
    void save(Student student);

    //删除
    void delete(int id);

    //更新
    void update(Student student);

    Student findById(int id);

    //查询所有
    List<Student> findAll();
}
