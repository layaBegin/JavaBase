package com.heima.user.service;


import com.heima.pojo.User;
import com.heima.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务层
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id查询用户
     */
    public User findOne(Long id){
        User user = userMapper.selectById(id);
        return user;
    }
}
