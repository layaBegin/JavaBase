package com.heima.demo05_annotest2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo01_JUnit {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        Class studentClass = Class.forName("com.heima.demo05_annotest2.Student");
        Object o = studentClass.newInstance();
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            if (declaredMethod.isAnnotationPresent(MyTest.class)) {
                declaredMethod.invoke(o);
            }
        }
    }
}
