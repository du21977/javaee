package com.dobi.transaction.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 测试JdbcTemplate
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        //1.获取 Spring 容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationJdbcContext.xml");
        //2.根据 id 获取 bean 对象----获取JdbcTemplate对象
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        //3.执行操作--添加
//        jt.execute("insert into stu(name,age,class)values('何时',100,100)");
        //保存
        jt.update("insert into stu(name,age,class)values(?,?,?)","何时11",100,100);

        //删除
//        jt.update("delete from stu where id = ?",11);
    }

}
