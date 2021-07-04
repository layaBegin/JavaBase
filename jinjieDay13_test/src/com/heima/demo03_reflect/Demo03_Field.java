package com.heima.demo03_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo03_Field {
    public static void main(String[] args) throws Exception {
        /**
         * 反射获取 构造器对象
         */
        Class class1 = Class.forName("com.heima.demo03_reflect.Student");
        //获取公有变量
        Field field = class1.getField("sex");
        System.out.println(field);
        //获取私有变量
        Field field1 = class1.getDeclaredField("name");

    }
}
