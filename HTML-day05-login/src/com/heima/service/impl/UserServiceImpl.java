package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.dao.impl.UserDaoImpl;
import com.heima.entity.User;
import com.heima.service.UserServie;
//业务层
public class UserServiceImpl implements UserServie {

    UserDao userDao = new UserDaoImpl();
    /**
     * 登录的功能
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = userDao.findUser(username, password);
        return user;
    }
}
