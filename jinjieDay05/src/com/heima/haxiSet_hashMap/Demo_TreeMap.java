package com.heima.haxiSet_hashMap;

import java.util.*;

/**
 * 原理参照 TreeSet
 * 必须排序，不重复，无索引
 */
public class Demo_TreeMap {
    public static void main(String[] args) {
        Map<Student1,Integer> map = new TreeMap(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                return o1.getAge() - o2.getAge() >=0 ? 1 : -1;
            }
        });
        map.put(new Student1("zhangshan",19),100);
        map.put(new Student1("lishi",20),50);
        map.put(new Student1("zhangshan",19),89);
        map.put(new Student1("wangwu",17),90);
        System.out.println(map);
    }
}

class Student1  implements Comparable<Student1>{
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public Student1(){

    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' ;
    }


    @Override
    public int compareTo(Student1 o) {
        return this.getAge() - o.getAge() >=0 ? 1 : -1;
    }
}
