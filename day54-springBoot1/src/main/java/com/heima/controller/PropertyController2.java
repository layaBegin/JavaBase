package com.heima.controller;

import com.heima.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
//@EnableConfigurationProperties 该注解的本质其实就是创建指定类的对象@Compnent注解,存储spring的容器
@EnableConfigurationProperties(PropertyConfig.class)
public class PropertyController2 {

    //使用springboot的 @Autowired注解的使用很多时候有红色波浪线，idea的问题,只需要添加required = false即可
    @Autowired(required = false)
    private PropertyConfig propertyConfig;

    @RequestMapping("/prop2")
    public String prop2(){
        System.out.println("主机号："+ propertyConfig.getHost());
        System.out.println("端口："+ propertyConfig.getPort());
        System.out.println("用户："+ propertyConfig.getUser());
        System.out.println("地址："+ Arrays.toString(propertyConfig.getAddress()));
        System.out.println("用户群体："+ propertyConfig.getUserList());
        return "读取yml成功";

    }


}
