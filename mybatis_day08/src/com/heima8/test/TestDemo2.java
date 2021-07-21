package com.heima8.test;

import com.heima8.dao.OrdersMapper;
import com.heima8.dao.UserMapper;
import com.heima8.pojo.Orders;
import com.heima8.pojo.Role;
import com.heima8.pojo.User;
import com.heima8.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestDemo2 {

    //注解反射执行sql 无需配置对应的xml
    @Test
    public void test01() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findUserById(41);
        System.out.println(user);
        MybatisUtils.commitAndClose(session);
    }

    @Test
    public void testInsert() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user1 = new User(null, "上的飞机", "2020-3-9", "nan", "gfd",null);
        int count = mapper.insertUser(user1);
        System.out.println("被影响的行数："+count);
        MybatisUtils.commitAndClose(session);
    }

    @Test
    public void testUpdate() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(49);
        user.setUsername("高圆圆");

        int count = mapper.updateUserById(user);
        System.out.println("被影响的行数："+count);
        MybatisUtils.commitAndClose(session);
    }

    @Test
    public void testDelete() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        int count = mapper.deleteUserById(49);
        System.out.println("被影响的行数："+count);
        MybatisUtils.commitAndClose(session);
    }
}
