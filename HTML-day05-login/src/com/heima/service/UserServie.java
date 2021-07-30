package com.heima.service;

import com.heima.entity.User;

/*
业务层
 */
public interface UserServie {

    /**
     * 登录的功能
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

}
