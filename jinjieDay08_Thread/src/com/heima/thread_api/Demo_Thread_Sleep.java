package com.heima.thread_api;

/**
 * 线程休眠
 */
public class Demo_Thread_Sleep {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("输出："+i);

            //执行会变慢
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
