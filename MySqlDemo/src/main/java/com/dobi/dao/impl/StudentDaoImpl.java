package com.dobi.dao.impl;



import com.dobi.bean.Student;
import com.dobi.dao.StudentDao;
import com.dobi.jdbcutils.JdbcUtil02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 *
 *  @描述：    这个类是针对student的数据库crud
 */
public class StudentDaoImpl implements StudentDao {
    private static final String TAG = "StudentDaoImpl";

    @Override
    public void save(Student student) {
        Connection conn  = null;
        PreparedStatement ps =null;
        try {
           conn = JdbcUtil02.getConn();
            String sql = "insert into stu values(null , ? , ? ,?)";
           ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2,student.getAge());
            ps.setInt(3,student.getClass1());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil02.close(conn , ps);
        }

    }

    @Override
    public void delete(int id) {
        Connection conn  = null;
        PreparedStatement ps =null;
        try {
            conn = JdbcUtil02.getConn();
            String sql = "delete from stu where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil02.close(conn , ps);
        }
    }




    @Override
    public void update(Student student) {
        Connection conn  = null;
        PreparedStatement ps =null;
        try {
            conn = JdbcUtil02.getConn();
            String sql = "update stu set age = ?  where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getAge());
            ps.setInt(2,student.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil02.close(conn , ps);
        }
    }

    @Override
    public Student findById(int id) {
        Connection conn  = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil02.getConn();
            String sql = "select * from stu where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

           rs= ps.executeQuery();
           Student stu  = new Student();
           while (rs.next()){

               stu.setId(rs.getInt("id"));
               stu.setName(rs.getString("name"));
               stu.setAge(rs.getInt("age"));
           }
           return stu;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil02.close(conn , ps , rs);
        }

        return null;
    }

    @Override
    public List<Student> findAll() {

        Connection conn  = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil02.getConn();
            String sql = "select * from stu ";
            ps = conn.prepareStatement(sql);

            rs= ps.executeQuery();

            List<Student> list = new ArrayList<Student>();
            while (rs.next()){
                Student stu  = new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));

                list.add(stu);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil02.close(conn , ps , rs);
        }

        return null;
    }
}
