package com.dobi.jdbcutils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
 *
 *  @描述：    这是jdbc的工具类，包含了获取连接 以及 释放连接的操作
 *              使用了properties来记录连接信息
 */
public class JdbcUtil02 {
    private static final String TAG = "JdbcUtil";

    private static String driverClassName ;
    private static String url ;
    private static String username ;
    private static String password ;



    static{
        try {


            //要给上面的4个变量赋值， 他们的值来自于jdbc.properties文件 ， 这就要求要读取这个properties文件
            Properties properties = new Properties();

            //指定properties的数据源在哪里
            InputStream is = JdbcUtil02.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);

            driverClassName =  properties.getProperty("driverClassName");
            url =  properties.getProperty("url");
            username =  properties.getProperty("username");
            password =  properties.getProperty("password");

            Class.forName(driverClassName);
        } catch (Exception e) {
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

        close(conn,statement,null);

    }

    /**
     * 关闭连接，释放资源
     */
    public static void close(Connection conn , Statement statement , ResultSet rs){

        try {
            if(statement != null){
                statement .close();
            }

            if(conn != null){
                conn.close();
            }
            if(rs !=null){
                rs =null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
