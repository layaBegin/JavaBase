package com.heima1.dao;

import com.heima1.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;


/**
 数据访问层方法
 */
public interface UserMapper {

    /**
     查询所有的用户
     */
    List<User> findAllUsers();

    /*
    参数的映射，
    1）自动映射
        前提：参数有且只有一个
    2）手动映射
       参数两个或以上

     */
    int addUser(User user);

    int addUser2(@Param("username") String u,@Param("birthday") String b,@Param("sex") String s,@Param("address") String a);
    int addUser3(@Param("user") User user);

    int updateUser(User user);

    //如果是其他类型 直接 #{}
    int deleteUser(int i);

    List<User> findUserByKid(String s);
    int insertReturnId(User user);

    List<User>  dynamicSql(@Param("name") String name,@Param("sex") String sex);

    int updateDynamicSql(User user);

    List<User> findByIdsSql(@Param("ids") ArrayList<Integer> arrayList);
}