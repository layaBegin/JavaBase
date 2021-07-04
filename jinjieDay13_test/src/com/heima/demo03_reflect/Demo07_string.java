package com.heima.demo03_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo07_string {
    public static void main(String[] args) throws Exception {
        /**
         *
         */
        String s = "abc";
        Class aClass = s.getClass();

        Field field = aClass.getDeclaredField("value");
        field.setAccessible(true);
        byte[] bytes = (byte[])field.get(s);
        bytes[0] = 100;
        System.out.println(Arrays.toString(bytes));
        System.out.println(s);


    }
}
