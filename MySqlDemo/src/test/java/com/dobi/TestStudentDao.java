package com.dobi;


import com.dobi.bean.Student;
import com.dobi.dao.StudentDao;
import com.dobi.dao.impl.StudentDaoImpl;
import org.junit.Test;

/*
 *  测试dao
 *  @创建时间:  2018/6/9 14:45
 *  @描述：    TODO
 */
public class TestStudentDao {
    private static final String TAG = "TestStudentDao";

    @Test
    public void testSave(){

        Student student = new Student();
        student.setName("aobama");
        student.setAge(18);


       // StudentDaoImpl studentDao = new StudentDaoImpl();

        //java基础里面的多态。 父类的引用指向子类对象 |接口的引用指向实现类的对象。
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.save(student);

    }


    @Test
    public void testUpdate(){
        StudentDao studentDao = new StudentDaoImpl();
        Student stu =  studentDao.findById(10);
        stu.setAge(29);

        studentDao.update(stu);
    }

    @Test
    public void testDelete(){
        StudentDao studentDao = new StudentDaoImpl();

        studentDao.delete(10);
    }

    @Test
    public void testFindAll(){
        StudentDao studentDao = new StudentDaoImpl();

        System.out.println(studentDao.findAll());
    }


}
