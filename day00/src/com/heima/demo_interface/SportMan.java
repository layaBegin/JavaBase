package com.heima.demo_interface;

//接口中只能是抽象方法和常量，都是public
public interface SportMan {
    //1.常量
    public static final String SCHOOLNAME = "黑马程序员";
    //2.抽象方法 ,写不写 public abstract 都一样
    void run();
    public abstract void run1();
}
