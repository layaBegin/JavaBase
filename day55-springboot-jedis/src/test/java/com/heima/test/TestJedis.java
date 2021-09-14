package com.heima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJedis {

    @Autowired
    private Jedis jedis;
    @Test
    public void test1(){
        jedis.set("jname","wangwu");
        System.out.println(jedis.get("jname"));
    }
}
