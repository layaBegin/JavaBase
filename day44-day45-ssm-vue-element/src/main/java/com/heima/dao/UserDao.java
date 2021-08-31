package com.heima.dao;

import com.heima.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * 用户的持久层
 */
public interface UserDao {

    /**
    根据用户名和密码查询用户是否存在
     */
    @Select("SELECT * FROM tab_user WHERE username=#{username} AND `password`=#{password}")
    User findUser(@Param("username") String username, @Param("password") String password);

}
