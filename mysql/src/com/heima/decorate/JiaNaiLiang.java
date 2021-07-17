package com.heima.decorate;

public class JiaNaiLiang implements Actor{
    @Override
    public void show(int money) {
        System.out.println("亮了，亮了");
    }

    @Override
    public void play(int money) {
        System.out.println("你真是个演员");
    }

    @Override
    public void method1() {

    }
}
