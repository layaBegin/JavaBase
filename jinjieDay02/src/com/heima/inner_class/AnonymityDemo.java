package com.heima.inner_class;

public class AnonymityDemo {
    public static void main(String[] args) {
        //匿名内部类
        Emplomee e = new Emplomee() {
            @Override
            void eat() {
                System.out.println("可以直接new 抽象类，但是得重写里面的方法");
            }
        };
        e.eat();

    }
}

abstract class Emplomee{
    abstract void eat();
}