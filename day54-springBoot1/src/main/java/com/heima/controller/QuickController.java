package com.heima.controller;

import com.heima.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
//@ConfigurationProperties(prefix = "my")
public class QuickController {
    /*@Value("${my.host}") //Value 注解不能读取引用类型数据
    private String host;
    @Value("${my.port}")
    private String port;*/


    private String host;
    private Integer port;
    private User user;//@Value注解不能读取引用类型数据,所以用 ConfigurationProperties

    private String address[];
    private List<User> userList;

    @RequestMapping("/quick")
    public String quickTest(){

        return "这是一个springBoot工程,启用热部署，成功，风格恢复十三点";
    }

    @RequestMapping("/prop")
    public String prop1(){
        System.out.println("主机号："+ host);
        System.out.println("端口："+ port);
        System.out.println("用户："+ user);
        System.out.println("地址："+ Arrays.toString(address));
        System.out.println("用户群体："+ userList);
        return "读取yml成功";

    }

    //想要使用ConfigurationProperties 注解方式读取 .yml 文件，一定要设置set 方法
    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
