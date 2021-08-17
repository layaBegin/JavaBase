package com.heima.test;

import com.heima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccount {
    @Autowired
    private AccountService accountService;

    @Test
    public void  test1(){
        System.out.println(accountService.getClass());
        accountService.transfer("Jack","Rose",100);
        System.out.println("测试类ok");
    }
}
