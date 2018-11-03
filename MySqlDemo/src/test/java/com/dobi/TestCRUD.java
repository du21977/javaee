package com.dobi;


import com.dobi.jdbcutils.JdbcUtil02;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *
 *  @描述：    TODO
 */
public class TestCRUD {
    private static final String TAG = "TestCRUD";



    //保存
    @Test
    public void save(){
        Connection conn = null;
        Statement statement = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行操作
            statement = conn.createStatement();

            String sql = "insert into stu values(null , '李白',29,3)";
            int result = statement.executeUpdate(sql);

            System.out.println("result=" + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil02.close(conn , statement);
        }
    }


    //更新
    @Test
    public void update(){
        Connection conn = null;
        Statement statement = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行操作
            statement = conn.createStatement();

            String sql = "update stu set age = 18 where id = 7";
            int result = statement.executeUpdate(sql);

            System.out.println("update == result=" + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil02.close(conn , statement);
        }
    }


    //删除
    @Test
    public void delete(){
        Connection conn = null;
        Statement statement = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行操作
            statement = conn.createStatement();

            String sql = "delete from stu where id = 2";
            int result = statement.executeUpdate(sql);

            System.out.println("update == result=" + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil02.close(conn , statement);
        }
    }

    //===========================================================

    @Test
    public void findAll(){

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行操作
            statement = conn.createStatement();

            String sql = "select * from stu";
            rs = statement.executeQuery(sql);


            //3. 从rs里面获取结果。 rs: 结果集。
            //rs.next()  移动游标到下一条记录，如果能移动，就是true,否则就是false 表示没有数据了。
             while(rs.next()){

                 //参数可以写两种： 列的索引 | 列的名字
                int id =  rs.getInt("id");
                String name=  rs.getString("name");
                int age =  rs.getInt("age");

                 System.out.println(id + " : " + name + " : " + age);
             }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , statement , rs);
        }

    }


    @Test
    public void findById(){

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行操作
            statement = conn.createStatement();

            String sql = "select * from stu where id = 8";
            rs = statement.executeQuery(sql);


            //3. 从rs里面获取结果。 rs: 结果集。
            //rs.next()  移动游标到下一条记录，如果能移动，就是true,否则就是false 表示没有数据了。

            while(rs.next()) {
                //参数可以写两种： 列的索引 | 列的名字
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);

                System.out.println(id + " : " + name + " : " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , statement , rs);
        }

    }


    @Test
    public void findCount(){

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行操作
            statement = conn.createStatement();

            String sql = "select count(id) from stu";
            rs = statement.executeQuery(sql);


            //3. 从rs里面获取结果。 rs: 结果集。
            //rs.next()  移动游标到下一条记录，如果能移动，就是true,否则就是false 表示没有数据了。

            while(rs.next()) {
                //参数可以写两种： 列的索引 | 列的名字

                System.out.println(rs.getInt(1));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , statement , rs);
        }

    }


}
