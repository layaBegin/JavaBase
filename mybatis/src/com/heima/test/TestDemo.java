package com.heima.test;

import com.heima.dao.UserMapper;
import com.heima.entity.User;
import com.heima1.test.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestDemo {
    @Test
    public void inert() throws IOException {
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
        User user = new User(null, "王五", "2020-3-2", "男", "广州");
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(user);
        session.commit();
        session.close();
    }

    @Test
    public void update() throws IOException {
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
        User user = new User(3, "瘪三", "2020-3-2", "男", "广州");
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.updateUser(user);
        System.out.println("被影响的行数："+i);
        session.commit();
        session.close();
    }

    @Test
    public void delete() throws IOException {
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
        User user = new User(3, "瘪三", "2020-3-2", "男", "广州");
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUser( 5);
        System.out.println("被影响的行数："+i);
        session.commit();
        session.close();
    }

    @Test
    public void delete1() throws IOException {
        SqlSession session =  MybatisUtils.openSession();
        //5. 会话对象得到UserMapper接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 生成了代理对象：org.apache.ibatis.binding.MapperProxy@198b6731
        System.out.println(userMapper);
        //User user = new User(1, "瘪三", "2020-3-2", "男", "广州");
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUser( 1);
        System.out.println("被影响的行数："+i);
        MybatisUtils.commitAndClose(session);
    }
}
