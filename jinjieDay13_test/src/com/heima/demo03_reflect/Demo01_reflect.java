package com.heima.demo03_reflect;

public class Demo01_reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 反射获取class字节码文件的3种方式
         */
        Class class1 = Class.forName("com.heima.demo03_reflect.Student");
        System.out.println(class1);
        Class class2 = Student.class;
        System.out.println(class2);

        Student student = new Student();
        Class class3 = student.getClass();
        System.out.println(class3);
        System.out.println(class1 == class2);
    }
}
