package com.heima.test;

import com.heima.dao.UserMapper;
import com.heima.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 使用mybatis访问数据库
 */
public class TestUserMapper {

    public static void main(String[] args) throws IOException {
        //1. 得到输入流对象
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2. 创建会话工厂建造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3. 通过建造类得到会话工厂类
        SqlSessionFactory factory = builder.build(inputStream);
        //4. 通过会话工厂得到会话对象
        SqlSession session = factory.openSession();
        //5. 会话对象得到UserMapper接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 生成了代理对象：org.apache.ibatis.binding.MapperProxy@198b6731
        System.out.println(userMapper);
        //6. 执行查询操作
        List<User> users = userMapper.findAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        //7. 关闭会话
        session.close();
    }



}