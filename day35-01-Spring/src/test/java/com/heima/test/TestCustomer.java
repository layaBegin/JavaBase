package com.heima.test;

import com.heima.config.CustomerConfig;
import com.heima.entity.Customer;
import com.heima.entity.Person;
import com.heima.service.CustomerService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestCustomer {

    //使用类路径
    @Test
    public void  test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService =(CustomerService)context.getBean("customerService");
        customerService.saveCustomer();
        context.close();
    }

    //使用全路径
    @Test
    public void  test2(){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("E:\\黑马\\JavaBase\\day35-01-Spring\\src\\main\\resources\\applicationContext.xml");
        CustomerService customerService =(CustomerService)context.getBean("customerService");
        customerService.saveCustomer();
        context.close();
    }

    //在注解的配置类中读取一个对象
    @Test
    public void  test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);
        CustomerService customerService =(CustomerService)context.getBean("customer");
        customerService.saveCustomer();
        context.close();
    }

    //在注解的配置类中读取一个对象
    @Test
    public void  testBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService =(CustomerService)context.getBean("cc");
        customerService.saveCustomer();
        context.close();
    }
    //在注解的配置类中读取一个对象
    @Test
    public void  testScope(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService1 =(CustomerService)context.getBean("cc");
        CustomerService customerService2 =(CustomerService)context.getBean("aaa");
        System.out.println(customerService1.equals(customerService2));
        customerService1.saveCustomer();
        context.close();
    }


    //构造的时候赋值
    @Test
    public void  testConstructor(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = context.getBean("customer", Customer.class);
        System.out.println(customer);
        context.close();
    }

    //构造的时候赋值
    @Test
    public void  testPserson(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person);
        context.close();
    }
}
