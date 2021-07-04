package com.heima.demo03_reflect;

import java.lang.reflect.Field;

public class Demo04_field1 {
    public static void main(String[] args) throws Exception {
        /**
         * 反射获取 构造器对象
         */
        Class class1 = Class.forName("com.heima.demo03_reflect.Student");
        Student student = new Student();
        Field fieldName = class1.getDeclaredField("name");
        //给私有变量赋值，必须先设定权限
        fieldName.setAccessible(true);
        fieldName.set(student,"zhangshan");
        System.out.println(student.getName());

    }
}
