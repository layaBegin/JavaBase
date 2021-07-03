package com.heima.demo00_network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Demo_network {
    /**
     * 常见互联网软件架构
     * C/S  客户端到服务器  需要下载客户端软件的都是
     * B/S Broswer /Server  浏览器打开的
     *
     */
    /**
     * 网络编程的3要素
     * 1，IP 找到对方电脑 ，设备在网络中的唯一标识
     * 2，端口，找到电脑中的 应用，每个端口绑定一个应用，但一个应用可以绑定多个端口
     * 3，协议：数据在网络中的传输规则 如 UDP、TCP
     */
    /**
     * IP 地址的分类
     * 公网Ip：对外ip（万维网）
     * 局域网：192.168.开头的就是私有地址，我们电脑看到的都是私有地址，转为组织内部使用，以此节省ip
     *
     * ipconfig  命令 查看电脑ip
     * ping 检查网络是否联通 ，也可以ping 局域网的ip
     *
     * 特殊ip ：127.0.0.1 即localhost 本机ip 永远找到当前所在本机
     */


    public static void main(String[] args) throws UnknownHostException {
        InetAddress address =  InetAddress.getByName("192.168.199.1");
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
        System.out.println(Arrays.toString(address.getAddress()));

    }
}
