package com.heima.demo03_reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo06_list {
    public static void main(String[] args) throws Exception {
        /**
         *
         */
        List<String> list = new ArrayList<>();
        list.add("aa");
        Class aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,343);
        System.out.println(list);


    }
}
