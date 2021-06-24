package com.heima.interface_JDK8;

public class Demo_interface {
    public static void main(String[] args) {
        PingpongMan pingpongMan = new PingpongMan();
        pingpongMan.run();
        SportsMan.inAddr();
    }
}

class PingpongMan implements SportsMan{

}


interface SportsMan{

    /*1，写默认方法
    * 接口可以写默认方法（相当于实例方法），但必须default修饰
    * 1，接口里只能包含常量和抽象方法
    * 2，接口里所有的 都默认public 修饰
    * */
    default void run(){
        System.out.println("====跑的很快===");
        go();
    }
    /*2，静态方法
    接口的静态方法必须用接口名称来调用
    * */
    static void inAddr(){
        System.out.println("静态方法");
    }
    /*3.私有方法，从JDK1.9 开始
    只能在接口内部，用默认方法调用
    * */
    private void go(){
        System.out.println("=====私有方法");
    }
}