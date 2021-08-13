package com.heima.service.Impl;

import com.heima.dao.UserDao;
import com.heima.entity.User;
import com.heima.service.UserService;
import com.heima.utils.DaoInstanceFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
     UserDao userDao = DaoInstanceFactory.getBean(UserDao.class);
    @Override
    public List<User> findUserByPrefix(String name) {
        return userDao.findUserByPrefix(name);
    }
}
