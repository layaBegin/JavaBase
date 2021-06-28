package com.heima.haxiSet_hashMap;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * HashSet 对自定义对象去重，必须重写 equals 和 hashCode 方法
 */
public class Demo_hashSet2 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("zhangshan",19,01));
        set.add(new Student("lishi",20,02));
        set.add(new Student("zhangshan",19,01));
        set.add(new Student("wangwu",17,03));
        System.out.println(set);
    }
}


class Student{
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
    public Student(){

    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private int age;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}' + "\n";
    }


}