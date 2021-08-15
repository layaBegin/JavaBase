package com.heima.test;

import com.heima.entity.Account;
import com.heima.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

    @Test
    public void testAccount(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account bean = context.getBean(Account.class);
        System.out.println(bean);
        context.close();
    }

    @Test
    public void testUser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User bean = context.getBean(User.class);
        System.out.println(bean);
        context.close();
    }
}
