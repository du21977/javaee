package com.dobi;


import com.dobi.jdbcutils.JdbcUtil02;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *  @描述：    该类演示的是statement的注入问题  注入：输入的值里面含有关键字，
 *          跳过了本来应该有的逻辑判断 ， 达到最终的效果。
 */
public class TestInjection {
    private static final String TAG = "TestInjection";


    @Test
    public void testLogin(){
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行操作
            statement = conn.createStatement();

            String sql = "select * from user where username = ' a'or'1=1   ' and password =' b'or'1=1   '  ";
           // String sql = "select * from user where username = ' true  ' and password =' true  '  ";
            rs = statement.executeQuery(sql);

            while (rs.next()){
                System.out.println(
                        rs.getInt("id") + " : "
                        + rs.getString("username") + " : "
                        + rs.getString("password"));

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil02.close(conn , statement , rs);
        }
    }
}
