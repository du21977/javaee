package com.dobi.dao;


import com.dobi.domain.QueryVo;
import com.dobi.domain.User;


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
     * 根据用户信息，查询用户列表 if--查询
     * @param user
     * @return
     */
    List<User> findByUser(User user);

    /**
     * 根据用户信息，查询用户列表--where查询
     * @param user
     * @return
     */
    List<User> findByUserWhere(User user);

    /**
     * 根据 id 集合查询用户--foreach
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);

}
