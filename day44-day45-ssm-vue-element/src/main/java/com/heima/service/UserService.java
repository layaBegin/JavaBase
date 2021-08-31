package com.heima.service;

import com.heima.entity.User;

/**
 * 用户业务层
 */
public interface UserService {

    /**
     * 用户登录功能
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回user对象
     */
    User login(String username, String password);

}
