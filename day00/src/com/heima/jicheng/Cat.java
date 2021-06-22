package com.heima.jicheng;

public class Cat extends Animal{
    public String name = "子类名字";

    public Cat(){
        this("兄弟的构造器");
        System.out.println("猫咪的无参构造器");
    }
    public Cat(String name){
        //super(name);// 默认有一个super 调用父类构造器，写不写都有
        this.name = name;
        System.out.println("猫咪的有参构造器");
    }

    @Override //重写注解，可读性好，安全
    public void run(){
        System.out.println("喵喵喵~");
        System.out.println("name:"+this.name);
        //System.out.println(super.name);
        //super.run();

    }
}
