package com.heima.dao;

import com.heima.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/*
持久层
 */
public interface UserDao {
    @Select("SELECT * FROM `user` WHERE username = #{username} AND PASSWORD = #{password}")
    User findUser(@Param("username") String username,@Param("password") String password);
}
