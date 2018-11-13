package com.dobi.domain;

import java.io.Serializable;

/**
 *  查询条件对象
 */
public class QueryVo implements Serializable {
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
