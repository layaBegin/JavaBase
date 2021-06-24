package com.heima.Demo_Object;

import java.util.Objects;

public class Demo_Object {
    public static void main(String[] args) {
        Student st = new Student("zhangshan",19);
        Student st1 = new Student("zhangshan",19);
        Student st2 = null;
        System.out.println(st);//实际调用的是Object 里面的toString方法
        System.out.println(st.toString());//
        System.out.println(st.equals(st1));//Object 方法，比较两个类的地址
        System.out.println(Objects.equals(st2,st));//用Objects 里的equal 更安全
    }
}
/*
* Object 是一切类的基类，默认继承Object 类
* */
class  Student{
    private String name;
    private int age ;
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public Student(){

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //可以重写Object 的 toString方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //可以重写 equals 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);//Objects 也是Object的子类
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
