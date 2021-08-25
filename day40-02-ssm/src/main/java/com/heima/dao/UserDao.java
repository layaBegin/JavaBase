package com.heima.dao;

import com.heima.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有联系人
     */
    List<User> findAll();
    @Insert("insert into user values(null,#{username},#{birthday},#{sex},#{address})")
    Integer addUser(User user);
    @Delete("delete from user where id=#{id}")
    Integer deleteUser(Integer id);
}
