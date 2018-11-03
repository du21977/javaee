package com.dobi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*

 */
public class TestDemo {
    private static final String TAG = "TestDemo";


    //该方法讲述注册驱动的代码细节
    public static void registerDriver() throws SQLException, ClassNotFoundException {

        //如果是这种注册手法，那么驱动会注册两次。
        //会执行两次的加载动作。

        //第一次： new Driver() ---> 这里会加载一次。

        //第二次，在Driver这个类当中有一段静态代码块
        /*static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
            }
        }*/


       // DriverManager.registerDriver(new Driver());

        //结论： 要想只注册一次驱动，只要执行一次静态代码块即可。  类加载的时候执行。 ---怎样才能让类加载
        //加载字节码到JVM， 静态代码也会执行。只要执行了一次，就会注册一次驱动。

        //参数要写类的全路径。
        Class.forName("com.mysql.jdbc.Driver");




    }


    public static void main(String [] args){


        Connection conn = null;
        Statement statement = null;

        try {
            //1. 注册驱动 ，其实背后的意思就是把连接mysql的类的字节码给加载到JVM中。
            //DriverManager.registerDriver(new Driver());

            //获取这个类的字节码，它里面的静态代码块会执行。
            Class.forName("com.mysql.jdbc.Driver");

            //2. 要想操作数据库，得建立连接。
            //http:// ---> heima:http://
            //主协议:子协议://数据库地址:端口号/数据库   如果是其他电脑的mysql , 那么使用ip地址
            String url = "jdbc:mysql://localhost:3306/student";//jdbc:subprotocol:subname


            //如果连接的是本机上的mysql,并且mysql的端口号还是3306 ，那么有一种简写的方式
            //String url = "jdbc:mysql:///itcast";

            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);

            //3. 往表里面添加一条记录。
            statement = conn.createStatement();

            String sql = "insert into stu values (null , '奥巴马3',22,5)";
            int result =  statement.executeUpdate(sql);

            System.out.println("result=" + result);

            System.out.println("conn=" + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement != null){
                    statement.close();
                    statement = null;
                }
                if(conn!=null){
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
