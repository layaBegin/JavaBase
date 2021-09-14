package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.domain.User;
import com.heima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAllUer() {
        return userDao.findAllU();
    }

    @Override
    public Integer save(User user) {
        return userDao.save(user);
    }
}
