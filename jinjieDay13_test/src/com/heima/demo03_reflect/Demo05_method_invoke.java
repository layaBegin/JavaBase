package com.heima.demo03_reflect;

import java.lang.reflect.Method;

public class Demo05_method_invoke {
    public static void main(String[] args) throws Exception {
        /**
         * 反射获取 构造器对象
         */
        Class class1 = Class.forName("com.heima.demo03_reflect.Student");
        Student student = new Student();


        Method add = class1.getMethod("add", int.class, int.class);
        Object invoke = add.invoke(student, 1, 3);
        System.out.println((int)invoke);

        Method fun = class1.getMethod("fun");
        fun.invoke(null);

    }
}
