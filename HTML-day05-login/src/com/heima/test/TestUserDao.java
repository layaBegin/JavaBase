package com.heima.test;

import com.heima.dao.UserDao;
import com.heima.dao.impl.UserDaoImpl;
import com.heima.entity.User;
import org.junit.Test;

public class TestUserDao {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void testFindUser(){
        User jack = userDao.findUser("Jack", "123");
        System.out.println(jack);
    }
}
