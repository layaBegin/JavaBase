package com.heima.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("user")
@PropertySource("classpath:user.properties")
public class User {

    @Value("${user.username}")
    private String name;

    @Value("${user.sex}")
    private boolean sex;

    @Value("${user.birthday}")
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}