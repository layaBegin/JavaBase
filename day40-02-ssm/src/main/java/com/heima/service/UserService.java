package com.heima.service;

import com.heima.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    Integer addUser(User user);
    Integer deleteUser(Integer id);
}
