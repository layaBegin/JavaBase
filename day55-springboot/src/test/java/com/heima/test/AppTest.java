package com.heima.test;


import com.heima.dao.UserDao;
import com.heima.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)  // 使用SpringRunner类去运行测试类

//指定启动类，如果测试类与启动类是同一级目录或者是属于启动类的子包，可以不指定
//@SpringBootTest(classes = MyBatisApplication.class )
@SpringBootTest
public class AppTest {

    @Autowired(required = false)
    private UserDao userDao;


    @Test
    public void test01(){
        List<User> userList = userDao.findAll();
        System.out.println("用户列表："+userList);
    }

}
