package com.heima.test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.List;
/**
 * 该案例与大家讲解的是zookeeper节点的监听器
 *      NodeCache  监听当前节点
 *      PathChildrenCache 监听子节点
 *      TreeCache  监听当前节点与子节点
 */
public class ListenerTest {

    //这个就是Carator的客户端
    private CuratorFramework client;

    //创建连接（Curator与zookeeper创建连接）
    @Before //执行测试方法之前执行的代码
    public void curatorConnection(){
        //创建一个重试与超时的对象  参数一： 连接的最大超时时间， 参数二：连接失败之后重连次数
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(2000, 2);
        client = CuratorFrameworkFactory.builder().retryPolicy(retryPolicy).
                connectString("192.168.199.130").build();
        client.start();
    }

    // *      NodeCache 监听当前节点。
    @Test
    public void nodeCache() throws Exception {
        NodeCache nodeCache = new NodeCache(client,"/app");
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            //只对当前数据变化起作用
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了："+ new String(nodeCache.getCurrentData().getData()) );
            }
        });
        nodeCache.start(); //这个方法并不是一个阻塞型方法，所以执行完毕马上就结束
        while(true); //这里我使用了死循环在这里只是为让当前的程序不要退出，部署在tomcat 上不会有这个问题
    }


    //*PathChildrenCache 监听子节点
    @Test
    public void pathChildrenCacheTest() throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app", true);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_ADDED)){
                    System.out.println("路径：" + event.getData().getPath() + "CHILD_ADDED的数据："+new String(event.getData().getData()));

                }else if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
                    System.out.println("路径：" + event.getData().getPath() + "CHILD_UPDATED数据："+ new String(event.getData().getData()) );

                }else if (event.getType().equals(PathChildrenCacheEvent.Type.CONNECTION_RECONNECTED)){
                    System.out.println("路径：" + event.getData().getPath() + "CHILD_UPDATED数据："+new String(event.getData().getData()));

                }else if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)){
                    System.out.println("路径：" + event.getData().getPath() + "CHILD_REMOVED："+new String(event.getData().getData()));

                }else {
                    System.out.println("===  变化了");
                }
            }
        });
        pathChildrenCache.start();
        while (true);
    }


    // *      TreeCache 监听当前节点与子节点
    @Test
    public void TreeCacheTest() throws Exception {
        TreeCache treeCache = new TreeCache(client,"/app");
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent event) throws Exception {
                if (event.getType().equals(TreeCacheEvent.Type.NODE_ADDED)){
                    System.out.println("路径："+ event.getData().getPath() +"添加："+ event.getData().getData());
                }else if (event.getType().equals(TreeCacheEvent.Type.NODE_REMOVED)){
                    System.out.println("路径："+ event.getData().getPath() +"NODE_REMOVED："+ event.getData().getData());

                }else if (event.getType().equals(TreeCacheEvent.Type.NODE_UPDATED)){
                    System.out.println("路径："+ event.getData().getPath() +"NODE_UPDATED："+ event.getData().getData());

                }
            }
        });
        treeCache.start();
        while (true);
    }

    @After
    public void close(){
        if (client != null){
            client.close();
        }
    }
}
