package com.heima.decorate;
/*
装饰设计模式：在不改变原类的情况下，增强其功能（继承可以实现，但不利于解耦，且不能复用）
    1）代理套路
        a，角色：代理对象，被代理对象  有共同父类

    2）

 */
public class MyProxy implements Actor{
    private Actor actor;
    public MyProxy(){

    }
    public MyProxy(Actor actor){
        this.actor = actor;
    }
    @Override
    public void show(int money) {
        if (money >= 100){
            actor.show(money);
        }else {
            System.out.println("钱太少了，不干");
        }
    }

    @Override
    public void play(int money) {
        if (money >= 200){
            actor.play(money);
        }else {
            System.out.println("钱太少了，不演");
        }
    }

    @Override
    public void method1() {

    }
}
