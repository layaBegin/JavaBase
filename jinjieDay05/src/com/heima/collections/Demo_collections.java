package com.heima.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections 工具类  和Collection不同
 */
public class Demo_collections {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        //添加所有
        Collections.addAll(list,"kladf ","da f","qa");
        System.out.println(list);
        //打乱
        Collections.shuffle(list);
        System.out.println(list);
        *//**
         * list 的比较 可以用Collections 来实现
         *//*
        Collections.sort(list);
        System.out.println(list);*/

        List<Apple> list = new ArrayList<>();

        Collections.addAll(list,new Apple("hei",1.1,500),new Apple("huang",2.1,200),new Apple("hong",2.3,400));
        //Collections.sort(list);
        Collections.sort(list, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Double.compare(o1.getPrice() , o2.getPrice());
            }
        });
        System.out.println(list);
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
