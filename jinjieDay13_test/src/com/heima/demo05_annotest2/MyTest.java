package com.heima.demo05_annotest2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
/*@Target({ElementType.TYPE,ElementType.METHOD})//注解的注解，规定注解的使用范围
public @interface TestAnno {
    *//*public String name();
    public int age();*//*
    public int value();
}*/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//声明注解的生命周期  字节码文件阶段
public @interface MyTest {

}