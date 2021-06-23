package com.heima.demo_ploymorphic;
//多态：同一个行为具有不同的表现形式或行为的能力

public class Demo_ploymorphic {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.run();//方法 编译看左，运行看右
        Animal b = new Wolf();
        b.run();//方法 编译看左，运行看右
        System.out.println(a.name);//属性没有多态，全部调用左边的
        System.out.println(b.name);//属性没有多态，全部调用左边的
    }
}
class Wolf extends Animal{
    public String name = "狼";
    @Override
    public void run() {
        System.out.println("狼在跑");
    }
}
class Dog extends Animal{
    public String name = "狗";

    @Override
    public void run() {
        System.out.println("狗再跑");
    }
}


class Animal{
    public String name = "父类名字";
    public void  run(){
        System.out.println("动物再跑");
    }
}

