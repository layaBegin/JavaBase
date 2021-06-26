package com.heima.JDK8_time;

import java.util.Arrays;
import java.util.Comparator;

public class Demo_ArraySort {
    public static void main(String[] args) {
        String[] arr = {"39","rrt","Brf","1"};
        Arrays.sort(arr);//根据ASCII 码排序
        System.out.println(Arrays.toString(arr));


        Student[] arrS = new Student[3];
        Student a = new Student("zhangshan",19,1);
        Student b = new Student("lishi",21,2);
        Student c = new Student("wangwu",18,3);

        arrS[0] = c;
        arrS[1] = b;
        arrS[2] = a;
        /*Arrays.sort(arrS, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        });*/
        //使用lambda 表达式简写
        Arrays.sort(arrS, (o1, o2)->o1.getId() - o2.getId());
        System.out.println(Arrays.toString(arrS));
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

    public Student(){

    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
