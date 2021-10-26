package com.heima.service.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dao.UserDao;
import com.heima.model.User;
import com.heima.service.UserService;
import org.springframework.stereotype.Service;

@Service
//还需要继承 serviceImplement
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public Integer updateOrder() {
        return null;
    }

}
