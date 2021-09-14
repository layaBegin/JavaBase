package com.heima.service;


import com.heima.model.User;

import java.util.List;

public interface UserService {

    //查找所有的用户
    List<User> findAll();
}
