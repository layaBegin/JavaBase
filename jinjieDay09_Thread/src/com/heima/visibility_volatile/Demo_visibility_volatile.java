package com.heima.visibility_volatile;

/**
 * volatile如何保证可见性
 * volatile修饰的变量一旦被线程工作内存修改，会直接把最新值写回主内存中
 * 其他线程如果工作内存中存了该共享变量的值，就会被通知失效
 *  其他线程下次读取该数据的时候会重新从主内存中获取最新的值
 */
public class Demo_visibility_volatile {
    public static void main(String[] args) {
        WifeThread t = new WifeThread();
        t.start();

        /**
         * volatile 能保证线程间的可见性，但并不能保证线程安全
         */
        /*while (true){
            if (t.getMoney() < 100000){
                System.out.println("===main:"+t.getMoney());

            }
        }*/



    }
}
