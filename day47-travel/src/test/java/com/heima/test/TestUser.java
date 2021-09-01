package com.heima.test;

import com.heima.travel.domain.User;
import com.heima.travel.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {

    @Autowired
    private UserService userService;
    @Test
    public void testUser(){
        User user = new User(0,"litty","123","123456765",null);
        userService.register(user);

    }
}
