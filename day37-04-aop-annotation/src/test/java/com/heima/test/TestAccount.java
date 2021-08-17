package com.heima.test;

import com.heima.service.AccountService;
import org.aspectj.lang.annotation.Pointcut;
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
        System.out.println("实现类:" + accountService.getClass() );
        accountService.saveAccount("rose");
    }

    @Test
    public void testUpdate(){
        accountService.update();
    }
}
