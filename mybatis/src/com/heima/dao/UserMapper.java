package com.heima.dao;

import com.heima.entity.User;

import java.util.List;


/**
 数据访问层方法
 */
public interface UserMapper {

    /**
     查询所有的用户
     */
    List<User> findAllUsers();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int i);
}