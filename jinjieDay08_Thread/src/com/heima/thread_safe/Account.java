package com.heima.thread_safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Account {
    private String id;
    private String name;

    /**
     * 方式3：Lock锁
     */
    public final Lock lock = new ReentrantLock();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private double money;

    public Account(double money) {
        this.money = money;
    }

    /*public void drawMoney(double money,String name) {
        System.out.println(Thread.currentThread());

        *//**方式一：同步代码块
         * 锁对象，保证这段代码同时只有一个对象执行,里面的参数无要求，只是一个标识
         *//*
        synchronized (this) {
            if (this.money >= money){
                System.out.println(name + "---开始取钱");
                this.money -= money;
                System.out.println("剩余钱数：" + this.money);
            }
        }
    }*/

    /**方式2：同步方法 方法前添加 synchronized 关键字
     *
     *//*
    public synchronized void drawMoney(double money,String name) {
        System.out.println(Thread.currentThread());

        if (this.money >= money){
            System.out.println(name + "---开始取钱");
            this.money -= money;
            System.out.println("剩余钱数：" + this.money);
        }

    }*/

    /**方式3：Lock 锁
     *
     */
    public  void drawMoney(double money,String name) {
        System.out.println(Thread.currentThread());
        lock.lock();
        try {
            if (this.money >= money){
                System.out.println(name + "---开始取钱");
                this.money -= money;
                System.out.println("剩余钱数：" + this.money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //无论上面代码是否报错，finally一定会执行，所以一定会解锁
            lock.unlock();
        }

    }
}
