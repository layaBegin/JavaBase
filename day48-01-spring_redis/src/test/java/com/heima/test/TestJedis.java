package com.heima.test;

import com.heima.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJedis {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test1() throws InterruptedException {
        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        stringObjectValueOperations.set("name","张三");
        System.out.println("从redis中取出："+stringObjectValueOperations.get("name"));
        stringObjectValueOperations.set("username","zhangshan",10, TimeUnit.SECONDS);
        Thread.sleep(11000);
        System.out.println(stringObjectValueOperations.get("username"));

        User user = new User();
        user.setId(1);
        user.setName("lishi");
        stringObjectValueOperations.set("user",user);
        System.out.println(stringObjectValueOperations.get("user"));
    }
}
