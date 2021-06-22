package com.heima.jicheng;

public class Animal {
    public String name = "父类名字";

    public Animal(){
        System.out.println("父类无参构造器");
    }
    public Animal(String name){
        this.name = name;
        System.out.println("父类有参构造器");
    }

    public void run(){
        System.out.println(name);
        System.out.println("动物在跑");
    }
}
