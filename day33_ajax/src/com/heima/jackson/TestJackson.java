package com.heima.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.com.heima.entity.User;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestJackson {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test1() throws IOException {
        User user = new User(1, "孙悟空", 30);
        //java 对象转json字符串
        String s = objectMapper.writeValueAsString(user);
        System.out.println("转成的json字符串："+s);
        //json 字符串转java对象
        User user1 = objectMapper.readValue(s, User.class);
        System.out.println("user1:"+user1);
    }
    @Test
    public void test2() throws IOException {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"zhangshan", "lishi", "wangwu");
        String s = objectMapper.writeValueAsString(list);
        System.out.println("转成的json数组："+ s);

        List list1 = objectMapper.readValue(s,List.class);
        System.out.println("json 数组转成list"+list1);
    }

    @Test
    public void test3() throws IOException {
        List<User> list = new ArrayList<>();
        Collections.addAll(list,new User(1,"sunwukong",18),new User(2,"zhubajie",30),
                new User(3,"shaheshang",50));
        String s = objectMapper.writeValueAsString(list);
        System.out.println("转成的json数组："+ s);

        //string 转泛型集合
        List list1 = objectMapper.readValue(s,new TypeReference<List<User>>(){});
        System.out.println("json 数组转成list"+list1);
    }
}
