package com.heima.demo8_concurrentHashmap;

import java.util.concurrent.CountDownLatch;

public class Demo_CountDownLatch {
    public static void main(String[] args) {
        //等待3个countDown
        CountDownLatch count = new CountDownLatch(3);
        MotherThread m = new MotherThread(count,"妈妈");
        ChildrenThread c1 = new ChildrenThread(count,"孩子1");
        ChildrenThread c2 = new ChildrenThread(count,"孩子2");
        ChildrenThread c3 = new ChildrenThread(count,"孩子3");

        m.start();
        c1.start();
        c2.start();
        c3.start();

    }
}


class  MotherThread extends Thread{
    /**
     *
     */
    private CountDownLatch c ;
    public CountDownLatch getC() {
        return c;
    }

    public void setC(CountDownLatch c) {
        this.c = c;
    }


    public MotherThread(CountDownLatch c,String name){
        super(name);
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("准备");
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("收碗");
    }
}


class  ChildrenThread extends Thread{
    public CountDownLatch getC() {
        return c;
    }

    public void setC(CountDownLatch c) {
        this.c = c;
    }

    private CountDownLatch c ;

    public ChildrenThread(CountDownLatch c,String name){
        super(name);
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("吃饭");
        System.out.println("吃完了");
        //等待人数减1
        c.countDown();

    }
}