package com.heima.demo03_reflect;

import java.lang.ref.PhantomReference;

public class Student {
    private String name;
    private int age;
    public String sex;
    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Student(String name) {
        this.name = name;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void eat(){
        System.out.println("学生在吃饭");
    }

    private void sing(){
        System.out.println("学生在唱歌");
    }

    public int add(int a,int b){
        return a + b;
    }

    public void shangke(String ke){
        System.out.println("学生在上课：" + ke);
    }

    public static void fun(){
        System.out.println("调用静态方法");
    }

}
