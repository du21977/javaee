package com.dobi;


import com.dobi.jdbcutils.JdbcUtil02;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 *
 *  @描述：    TODO
 */
public class TestPrepareStatement {
    private static final String TAG = "TestPrepareStatement";


    @Test
    public void save(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1. 获取连接
           conn = JdbcUtil02.getConn();

            //2. 构建对象
            /*Statement statement = conn.createStatement();
             String sql = "insert into student values(null ,'admin',19)";
            statement.executeUpdate(sql)*/

            // ? 称之为 占位符
            String sql = "insert into student values(null ,? , ?)";

            //会对sql语句进行预编译， ?的位置是动态赋值的地方，以后这个位置放什么字符进来，
            //永远都只会被认为是字符串。即便里面含有关键字也可以。
            ps = conn.prepareStatement(sql);

            //对?进行赋值 参数一：是占位符的下标索引，  参数二： 是真正要存到数据库的值
            ps.setString(1 , "admin");
            ps.setInt(2 ,19 );

            //执行操作
            int result = ps.executeUpdate();

            System.out.println("result=" + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , ps);
        }
    }

    @Test
    public void update(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            // ? 称之为 占位符
            String sql = "update student set age = ? where id = ?";

            //会对sql语句进行预编译， ?的位置是动态赋值的地方，以后这个位置放什么字符进来，
            //永远都只会被认为是字符串。即便里面含有关键字也可以。
            ps = conn.prepareStatement(sql);

            //对?进行赋值 参数一：是占位符的下标索引，  参数二： 是真正要存到数据库的值
            ps.setInt(1 , 99);
            ps.setInt(2 ,9 );

            //执行操作
            int result = ps.executeUpdate();

            System.out.println("result=" + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , ps);
        }
    }

    @Test
    public void delete(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            // ? 称之为 占位符
            String sql = "delete from student where id = ?";

            //会对sql语句进行预编译， ?的位置是动态赋值的地方，以后这个位置放什么字符进来，
            //永远都只会被认为是字符串。即便里面含有关键字也可以。
            ps = conn.prepareStatement(sql);

            //对?进行赋值 参数一：是占位符的下标索引，  参数二： 是真正要存到数据库的值
            ps.setInt(1 , 9);


            //执行操作
            int result = ps.executeUpdate();

            System.out.println("result=" + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , ps);
        }
    }


    //查询
    @Test
    public void findAll(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            // ? 称之为 占位符
            String sql = "select * from student";

            //会对sql语句进行预编译， ?的位置是动态赋值的地方，以后这个位置放什么字符进来，
            //永远都只会被认为是字符串。即便里面含有关键字也可以。
            ps = conn.prepareStatement(sql);


            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt("id") + " : " + rs.getString("name") + " : " + rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , ps , rs);
        }
    }

    @Test
    public void findById(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            // ? 称之为 占位符
            String sql = "select * from student where id = ?";

            //会对sql语句进行预编译， ?的位置是动态赋值的地方，以后这个位置放什么字符进来，
            //永远都只会被认为是字符串。即便里面含有关键字也可以。
            ps = conn.prepareStatement(sql);
            ps.setInt(1,8);


            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt("id") + " : " + rs.getString("name") + " : " + rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , ps , rs);
        }
    }

    @Test
    public void findCount(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            // ? 称之为 占位符
            String sql = "select count(*) from student";

            //会对sql语句进行预编译， ?的位置是动态赋值的地方，以后这个位置放什么字符进来，
            //永远都只会被认为是字符串。即便里面含有关键字也可以。
            ps = conn.prepareStatement(sql);


            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , ps , rs);
        }
    }

    //=====================登录========================

    @Test
    public void testLogin(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            // ? 称之为 占位符
            String sql = "select * from user where username = ? and password = ?";

            //会对sql语句进行预编译， ?的位置是动态赋值的地方，以后这个位置放什么字符进来，
            //永远都只会被认为是字符串。即便里面含有关键字也可以。
            ps = conn.prepareStatement(sql);
            ps.setString( 1, "' a'or'1=1   '");  //
            ps.setString( 2, "' a'or'1=1   '");


//            String sql = "select * from user where username
//                          = ' a'or'1=1   ' and password =' b'or'1=1   '  ";

            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt("id") + " : " + rs.getString("username") + " : " + rs.getInt("password"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil02.close(conn , ps , rs);
        }
    }


}


