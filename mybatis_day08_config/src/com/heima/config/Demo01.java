package com.heima.config;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Demo01.class.getClassLoader().getResourceAsStream("aa.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String name = (String)properties.get("name");
        Student student = new Student(name);
        System.out.println(student);

    }
    @Test
    public  void test() throws Exception {
        Student student = new Student();
        Class<?> aClass = student.getClass();
        //获取所有权限的属性，getField 获取public 的属性
        Field nameF = aClass.getDeclaredField("name");
        //暴力反射，临时修改权限为true
        nameF.setAccessible(true);
        boolean annotationPresent = nameF.isAnnotationPresent(Gaoya.class);
        if (annotationPresent){
            Gaoya annotation = nameF.getAnnotation(Gaoya.class);
            String value = annotation.value();
            System.out.println(value);
            nameF.set(student,value);
            System.out.println(student);
        }



    }
}
