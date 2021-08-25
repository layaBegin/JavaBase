package com.hema.test;


import com.heima.service.UserService;
import com.heima.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }
}
