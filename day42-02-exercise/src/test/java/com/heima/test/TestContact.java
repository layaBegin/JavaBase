package com.heima.test;

import com.heima.entity.Contact;
import com.heima.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestContact {

    @Autowired
    private ContactService contactService;

    @Test
    public void test1(){
        List<Contact> all = contactService.findAll();
        System.out.println(all);
    }
}
