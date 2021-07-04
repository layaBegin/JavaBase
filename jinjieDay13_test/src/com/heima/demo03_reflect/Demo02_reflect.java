package com.heima.demo03_reflect;

import java.lang.reflect.Constructor;

public class Demo02_reflect {
    public static void main(String[] args) throws Exception {
        /**
         * 反射获取 构造器对象
         */
        Class class1 = Class.forName("com.heima.demo03_reflect.Student");
//        只能获取public 的构造函数
        Constructor[] constructors = class1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        //获取private public 的构造函数
        class1.getDeclaredConstructors();
        System.out.println(class1.getConstructor());
        System.out.println(class1.getConstructor(String.class, int.class));
        System.out.println(class1.getDeclaredConstructor(String.class));
    }
}
