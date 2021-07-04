package com.heima.demo03_reflect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Demo08_property {
    public static void main(String[] args) throws Exception {
        /**
         *
         */
        Student student  = new Student("zhangshan",18);
        Class aClass = student.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        BufferedWriter bw = new BufferedWriter(new FileWriter("jinjieDay13_test/src/test.txt"));
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            String[] split = declaredField.toString().split("\\.");
            if (split.length > 0){
                String s = split[split.length - 1];
                declaredField.setAccessible(true);
                bw.write(s+"="+ declaredField.get(student));
                bw.newLine();

            }
        }
        bw.close();


    }
}
