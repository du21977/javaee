package com.dobi.test;

import com.dobi.dao.IUserDao;

import com.dobi.domain.QueryVo;
import com.dobi.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis增删改查
 */
public class MyBatisDemo5Test {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;


    @Before//在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建 SqlSession 工厂对象
        factory = builder.build(in);
        //4.创建 SqlSession 对象
        session = factory.openSession();
        //5.创建 Dao 的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

//    我们在实现增删改时一定要去控制事务的提交，那么在 mybatis 中如何控制事务
//    提交呢？
//    可以使用:session.commit();来实现事务提交
    @After//在测试方法执行完成之后执行
    public void destroy() throws Exception {
        //来实现事务提交
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

    /**
     * 查找所有
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }



    @Test
    public void testFindByUser() {
        User u = new User();
        u.setUsername("%王%");
        u.setAddress("%顺义%");
        //6.执行操作
        List<User> users = userDao.findByUser(u);
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUserWhere() {
        User u = new User();
        u.setUsername("%王%");
        u.setAddress("%顺义%");
        //6.执行操作
        List<User> users = userDao.findByUserWhere(u);
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(46);
        ids.add(55);
        vo.setIds(ids);
        //6.执行操作
        List<User> users = userDao.findUserInIds(vo);
        for(User user : users) {
            System.out.println(user);
        }
    }


}
