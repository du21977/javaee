package com.dobi.jdbcutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *
 *  @描述：    这是jdbc的工具类，包含了获取连接 以及 释放连接的操作
 */
public class JdbcUtil {
    private static final String TAG = "JdbcUtil";

    private static String url = "jdbc:mysql://localhost:3306/itcast";
    private static String username = "root";
    private static String password = "root";


    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return
     */
    public static Connection getConn(){
        try {
          return   DriverManager.getConnection(url , username , password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 关闭连接，释放资源
     */
    public static void close(Connection conn , Statement statement ){

        try {
            if(statement != null){
                statement .close();
            }

            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
