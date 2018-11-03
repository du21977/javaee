package com.dobi.jdbcutils;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *  @描述：    这是jdbc的入门案例
 */
public class TestDemo {



    public static void main(String [] args){
        Connection conn = null;
        Statement  statement= null;
        try {
            //1. 获取连接
            conn = JdbcUtil02.getConn();

            //2. 执行添加操作
            statement = conn.createStatement();
            String sql = "insert into student values (null , '李白2')";
            int result = statement.executeUpdate(sql);

            System.out.println("result=" + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn ,statement);
        }
    }
}
