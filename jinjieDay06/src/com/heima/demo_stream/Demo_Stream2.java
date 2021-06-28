package com.heima.demo_stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream 不会直接修改源数据
 */
public class Demo_Stream2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("赵麻子");
        list.add("张山");
        list.add("李氏");
        list.add("张山峰");
        list.add("张山峰");
        list.add("张飞");

        Stream<String> stream = list.stream();
        stream.filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        System.out.println("-------------------");
        //流终结后就没了，必须重新生成流，报错
        //stream.filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        list.stream().filter(s -> s.startsWith("张")).limit(2).forEach(s -> System.out.println(s));
        System.out.println("--------");
        list.stream().filter(s -> s.startsWith("张")).skip(1).forEach(s -> System.out.println(s));
        System.out.println("-----distinct() 去重复");
        list.stream().filter(s -> s.startsWith("张")).skip(1).distinct().forEach(s -> System.out.println(s));
        System.out.println(list.stream().count());

        //map() 加工方法；
        list.stream().map(s -> "黑马："+s).forEach(s -> System.out.println(s));
        list.stream().map(s -> new Student(s)).forEach(student -> System.out.println(student));
        //合并流
        Stream<String> stream1 = list.stream();
        Stream<Integer> integerStream = Stream.of(1, 4, 5);
        Stream<Object> concat = Stream.concat(stream1, integerStream);
        System.out.println(concat.count());

    }
}

class Student{
    public String getName() {
        return name;
    }

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
