package com.heima.travel.dao;

import com.heima.travel.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("SELECT * FROM tab_user WHERE username =#{username}")
    User findUserByUsername(String username);
    @Select("SELECT * FROM tab_user WHERE telephone =#{telephone}")
    User findUserBytelephone(String telephone);

    @Insert("INSERT INTO tab_user VALUES(NULL,#{username},#{password},#{telephone},#{salt})")
    Integer saveUser(User user);
}
