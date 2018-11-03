package com.dobi;


import com.dobi.c3p0.JdbcC3p0Util;
import com.dobi.jdbcutils.JdbcUtil02;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 *  c3p0连接池
 *  @描述：    TODO
 */
public class TestC3p0Demo {
    private static final String TAG = "TestC3p0Demo";



    @Test
    public void testDemo2(){
        try {
            //创建数据源  的背后，回去读取刚才的那个配置文件，完成数据库的连接和连接池的配置
           // ComboPooledDataSource dataSource = new ComboPooledDataSource();

           // Connection conn = dataSource.getConnection();
            Connection conn = JdbcC3p0Util.getConn();
            String sql = "insert into stu values(null , ? , ? ,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1 ,"张三3");
            ps.setInt(2,39);
            ps.setInt(3,39);
            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDemo(){

        try {
            //DataSource d;

            //创建数据源
            ComboPooledDataSource dataSource = new ComboPooledDataSource();


            //知道set方法的名字，能推理出来属性的名字吗?
          /*
            name  --- setName();
            username --- setUername()
            driverClass-------setDriverClass*/
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///student");
            dataSource.setUser("root");
            dataSource.setPassword("root");


            //配置和连接池
            //最大有多少
            dataSource.setMaxPoolSize(20);
            //一开始有几个链接
            dataSource.setInitialPoolSize(10);




            Connection conn = dataSource.getConnection();
            String sql = "insert into stu values(null , ? , ?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1 ,"张三");
            ps.setInt(2,19);
            ps.setInt(3,19);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
