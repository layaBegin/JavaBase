package com.heima.Demo_Integer;
/*
*Java中为了 一切皆对象的思想，将基本类型变成了引用类型，即包装类
* 后续集合和泛型都只支持引用类型的包装类，不支持基本数据类型
* byte      Byte
* short     Short
* int       Integer
* float     Float
* double    Double
* char      Character
* boolean   Boolean
*
* */
public class Demo_Integer {
    public static void main(String[] args) {
        /*int i = 10;
        Integer i1 = i;//自动装箱，可以直接把基本类型的 数据或i这变量赋值给包装类
        Integer i2 = 2;

        i = i2;//自动拆箱
        System.out.println(i);*/


        Integer a = 13;
        String s = Integer.toString(a);
        System.out.println(s + 3);
        String s1 = "24";
        Integer a1 = Integer.parseInt(s1);
        Integer a2 = Integer.valueOf(s1);
        System.out.println(a2 + 1);
        Double d1 = Double.parseDouble(s1);
        Double d2 = Double.valueOf(s1);
        System.out.println(d2 + 1);
    }
}
