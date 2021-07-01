package com.heima.visibility_synchronized;

public class Demo_visibility_synchronized {
    public static void main(String[] args) {
        WifeThread t = new WifeThread();
        t.start();

        /**
         * 多线程之间修改共享变量不可见，
         * 原因：堆内存是唯一的，每一个线程都有自己的线程栈。
         * 每一个线程在使用堆里面变量的时候，都会先拷贝一份到变量的副本中。
         * 在线程中，每一次使用是从变量的副本中获取的
         */
        /*while (true){
            if (t.getMoney() < 100000){
                System.out.println("===main:"+t.getMoney());

            }
        }*/
        while (true){
            /**
             * 加锁为何可以实现可见性？
             * 堆内存是唯一的，每一个线程都有自己的线程栈。
             * 每一个线程在使用堆里面变量的时候，都会先拷贝一份到变量的副本中。
             * 在线程中，每一次使用是从变量的副本中获取的。
             * 每个线程在加锁时会清空原有的工作内存的副本，然后从主内存读取最新值
             */
            synchronized (Demo_visibility_synchronized.class){
                if (t.getMoney() < 100000){
                    System.out.println("===main:"+t.getMoney());

                }
            }

        }
    }
}
