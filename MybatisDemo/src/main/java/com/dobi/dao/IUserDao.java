package com.dobi.dao;

import com.dobi.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();


}
