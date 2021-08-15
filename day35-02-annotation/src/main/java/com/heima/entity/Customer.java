package com.heima.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
@Lazy
public class Customer {
    public Customer(){
        System.out.println("加载构造函数");
    }

    //初始化的时候加载
    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void destroy(){

    }
}
