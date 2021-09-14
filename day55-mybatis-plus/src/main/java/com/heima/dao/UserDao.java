package com.heima.dao;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 注意： 使用mybatis-plus的时候dao的接口需要继承 BaseMapper,
 * BaseMapper的接口将会给你带来大量的方法。
 */
public interface UserDao extends BaseMapper<User> {

    List<User> findAll();

    Page<User> findByPage(Page<User> page, @Param("age") Integer age);
}

