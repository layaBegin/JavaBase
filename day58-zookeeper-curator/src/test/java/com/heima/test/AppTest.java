package com.heima.test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AppTest {

    //这个就是Carator的客户端
    private CuratorFramework client;

    //创建连接（Curator与zookeeper创建连接）
    @Before //执行测试方法之前执行的代码
    public void curatorConnection(){
        //创建一个重试与超时的对象  参数一： 连接的最大超时时间， 参数二：连接失败之后重连次数
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(2000, 2);
        client = CuratorFrameworkFactory.builder().retryPolicy(retryPolicy).
                connectString("192.168.199.130:2181,192.168.199.130:2182,192.168.199.130:2183").build();
        client.start();
    }


    @Test
    public void createNode() throws Exception {
        //不带数据创建
        //client.create().forPath("/app");
        //带数据 创建
        //client.create().forPath("/app/p1","心机波".getBytes());
        // 指定临时模式
        //client.create().withMode(CreateMode.EPHEMERAL).forPath("/app/p2","sdfdf".getBytes());
        //创建多级节点
        client.create().creatingParentsIfNeeded().forPath("/d1025/student","lishi".getBytes());
    }

    @Test
    public void  getData() throws Exception {
        byte[] bytes = client.getData().forPath("/d1025/student");
        System.out.println("===获取："+ new String(bytes));
    }
    @Test
    public void  getChildren() throws Exception {
        List<String> list = client.getChildren().forPath("/");
        System.out.println(list);
    }

    @Test
    public void  getCounts() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/");
        System.out.println("根目录子节点个数："+stat.getNumChildren());
        System.out.println(stat.toString());
    }


    @Test
    public void  setNodeData() throws Exception {
        byte[] bytes = client.getData().forPath("/app2/student");
        System.out.println(new String(bytes));
        Stat stat = client.setData().forPath("/app2/student", "wangwu".getBytes());
        byte[] bytes2 = client.getData().forPath("/app2/student");
        System.out.println(new String(bytes2));
    }

    @Test
    public void  deleteNodeData() throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath("/app2");
    }

    @After
    public void close(){
        if (client != null){
            client.close();
        }
    }
}
