package com.heima.demo03_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo05_method {
    public static void main(String[] args) throws Exception {
        /**
         * 反射获取 构造器对象
         */
        Class class1 = Class.forName("com.heima.demo03_reflect.Student");
        Student student = new Student();
       /* Method[] methods = class1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

       /* //获取所有方法，包括私有
        Method[] methods1 = class1.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }*/

        Method add = class1.getMethod("add", int.class, int.class);
        System.out.println(add);
        Method sing = class1.getDeclaredMethod("sing");
        System.out.println(sing);

    }
}
