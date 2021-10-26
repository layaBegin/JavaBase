package com.heima;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

public class SellTicket implements Runnable {
    private int num = 500;

    //分布式锁对象
    private InterProcessMutex lock;

    public SellTicket() {
        //注意：由于InterProcessMutex这个锁对象是基于zookeeper去实现，所以获取该锁的时候必须要先连接Zookeeper
        //创建重试与超时对象
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000,2);
        //创建连接的客户端对象
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .retryPolicy(retryPolicy)
                .connectString("192.168.199.130:2181")
                .build();
        //开启客户端
        client.start();
        //创建lock对象   参数一：zookeeper连接客户端对象  参数： 指定使用哪个节点作为锁对象的节点
        lock = new InterProcessMutex(client,"/lock2");
        System.out.println("创建了锁对象");
    }

    @Override
    public void run() {

        while (true){
            try {
                lock.acquire(2, TimeUnit.SECONDS);
                if (num > 0){
                    System.out.println(Thread.currentThread().getName() + "卖出第" + num + "张票");
                    num --;
                }else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
