package com.heima.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 被扫描到以后，由Spring创建这个对象放到容器中去，默认是类名首字母小写做为名字
 * 也可以指定value属性，就是它的名字
 @Component:用于普通的类
 @Service：用于业务层的类
 @Repository：用于持久层
 @Controller：用于控制器
 注：以上四个注解的功能一样，只是语义上区别
 */
//默认类名首字母小写作为 id
//@Component
@Component("account")
public class Account {


    private Integer id;
    /**
     * 按类型匹配的方式从容器中找对应的值，并且注入
     * required = false 找不到不会抛异常，有多个而且名字也不匹配，还是会异常
     */
    @Autowired(required = false)
    @Qualifier("man")
    private String name;
    private Double money;

    public Account() {
    }

    public Account(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    @Autowired
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
