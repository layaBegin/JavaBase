package com.heima8.dao;

import com.heima8.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findUserById(int i);
    @Insert("insert into user values(null,#{username},#{birthday},#{sex},#{address})")
    Integer insertUser(User user1);
    @Update("update user set username = #{username} where id = #{id}")
    int updateUserById(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteUserById(Integer uid);
}
