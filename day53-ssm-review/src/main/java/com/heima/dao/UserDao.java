package com.heima.dao;

import com.heima.domain.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UserDao {

    List<User> findAllU();
    @Insert("insert into user VALUES(null,#{username},#{birthday},#{sex},#{address},#{dept_id}) ")
    Integer save(User user);
}
