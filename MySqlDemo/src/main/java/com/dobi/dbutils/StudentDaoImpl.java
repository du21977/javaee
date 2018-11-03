package com.dobi.dbutils;


import com.dobi.bean.Student;
import com.dobi.dao.StudentDao;
import com.dobi.jdbcutils.JdbcUtil02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
 *
 *  @描述：    TODO
 */
public class StudentDaoImpl implements StudentDao {
    private static final String TAG = "StudentDaoImpl";

    @Override
    public void save(Student student) {
        try {

            //1. 构建QueryRunner对象
            QueryRunner runner = new QueryRunner();

            //2. sql语句
            String sql = "insert into stu values(null , ? , ?)";

            //3. 执行操作 ，参数一： 连接对象，参数二： sql语句，参数三： 对应上面的第一个? 参数四对应上面的第二个?
            runner.update(JdbcUtil02.getConn() ,sql , student.getName(),student.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Student student) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "update student set age =? where id = ?";
            runner.update(JdbcUtil02.getConn() ,sql , student.getAge() , student.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "delete from student where id = ?";
            runner.update(JdbcUtil02.getConn() ,sql , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {

     /*   ResultSetHandler r;
        下面有三个常用的实现类 ：BeanHandler  |  BeanListHandler  | ScalarHandler
                BeanHandler: 返回结果是一个对象
                        BeanListHandler : 返回结果是一个集合里面装很多对象
                                ScalarHandler： 返回结果是聚合查询 就是一个数字   */

        try {
            QueryRunner runner = new QueryRunner();
            String sql = "select * from student where id = ?";

            Student stu = runner.query(JdbcUtil02.getConn(), sql, new BeanHandler<Student>(Student.class), id);

            return stu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "select * from student ";

            List<Student> list = runner.query(JdbcUtil02.getConn(), sql, new BeanListHandler<Student>(Student.class));

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
