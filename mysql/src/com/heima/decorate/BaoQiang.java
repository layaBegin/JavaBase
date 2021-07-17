package com.heima.decorate;

public class BaoQiang implements Actor{
    @Override
    public void show(int money) {
        System.out.println("宝强真人秀："+money);
    }

    @Override
    public void play(int money) {
        System.out.println("宝强演戏："+money);

    }

    @Override
    public void method1() {

    }
}
