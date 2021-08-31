package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.entity.User;
import com.heima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User login(String username, String password) {
        return userDao.findUser(username,password);
    }
}
