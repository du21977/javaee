package com.dobi.dao;

import com.dobi.domain.QueryVo;
import com.dobi.domain.User;
import com.dobi.domain.User1;

import java.util.List;

/**
 *
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     * 根据 id 查询
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 保存用户
     * @param user
     * @return 影响数据库记录的行数
     */
    int saveUser(User user);

    /**
     * 更新用户
     * @param user
     * @return 影响数据库记录的行数
     */
    int updateUser(User user);

    /**
     * 根据 id 删除用户
     * @param userId
     * @return
     */
    int deleteUser(Integer userId);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总记录条数
     * @return
     */
    int findTotal();

    /**
     * 根据 QueryVo 中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);


    /**
     * 查询所有操作
     * @return
     */
    List<User1> findAllResulutMap();
}
