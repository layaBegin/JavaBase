package com.heima.dao;

import com.heima.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("SELECT * FROM USER WHERE NAME LIKE CONCAT(#{name},'%')")
    List<User> findUserByPrefix(String name);
}
