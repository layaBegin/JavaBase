package com.heima.demo_interface;

//
public class Interface_demo {
    public static void main(String[] args) {

    }
}

//接口可以理解为干爹，可以继承多个
class PingPongMan implements SportsMan {

    @Override
    public void run() {
        System.out.println("张继科在跑步");
    }


    @Override
    public void rule() {

    }

    @Override
    public void eat() {

    }
}
//接口可以实现多继承接口，类只能单继承
interface SportsMan extends People, Law {
    void run();
}

interface Law {
    public abstract void rule();
}

interface People {
    void eat();
}