package com.heima.test;

import com.heima.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration("classpath:applicationContext.xml")
@ExtendWith(SpringExtension.class)
public class TestAccount {
    @Autowired
    AccountService accountService;
    @Test
    public void test1(){
        int count = accountService.saveAccount("rose");
        System.out.println("返回值："+ count);
    }
    @Test
    public void testUpdate(){
        accountService.update();
    }
}
