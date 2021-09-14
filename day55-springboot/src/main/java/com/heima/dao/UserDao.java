package com.heima.dao;

import com.heima.model.User;

import java.util.List;

/**
 * dao接口如果需要被映射到需要使用一下两种方法：
 *      1. 在dao接口的添加@Mapper注解， 这种方式弊端：每一个dao接口都需要添加该注解非常繁琐
 *      2. 在启动器类添加一个MapperScan注解，指定扫描的dao包、
 */
//@Mapper //方式1

//方式二 (@MapperScan注解)【推荐】
public interface UserDao {


    List<User> findAll();
}
