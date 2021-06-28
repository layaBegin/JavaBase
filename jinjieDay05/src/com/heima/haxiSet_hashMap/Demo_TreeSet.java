package com.heima.haxiSet_hashMap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet 不重复，无索引，必须排序
 * 底层基于红黑树排序，增删查改性能都较好
 *
 *  比较有两种方式
 *  1，类继承Comparable
 *  2，TreeSet 重写 Comparator
 *  3，如果比较两个元素 结果为 0 会自动去重。若要不自动去重复 ，可以自己修改
 */
public class Demo_TreeSet {
    public static void main(String[] args) {
        /*Set<String> set = new TreeSet<>();
        set.add("Java");
        set.add("Java");
        set.add("MySQL");
        set.add("MyBatis");
        set.add("Html");
        set.add("web");
        System.out.println(set);*/

        Set<Apple> sets = new TreeSet<>(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                //double 在这里不能直接算 比如 1.1 - 1.3== 0.2 ---》0 会删除这个元素
                return Double.compare(o1.getPrice(),o2.getPrice()) >=0 ? 1 : -1;
            }
        });
        sets.add(new Apple("buhei",2.2,200));
        sets.add(new Apple("hei",2.2,200));
        sets.add(new Apple("hong",2.0,300));
        sets.add(new Apple("lv",1.0,100));
        sets.add(new Apple("huang",1.5,500));
        System.out.println(sets);


    }
}

class Apple implements Comparable<Apple>{
    private String color;
    private double price;

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private int weight;

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
    public Apple(){

    }

    public Apple(String color, double price, int weight) {
        this.color = color;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}' +"\n";
    }


    @Override
    public int compareTo(Apple o) {
        return this.weight - o.weight  >=0 ? 1 : -1;
    }
}
