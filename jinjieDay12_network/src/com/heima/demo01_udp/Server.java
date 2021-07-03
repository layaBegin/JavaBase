package com.heima.demo01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        //接收时要指定端口
        DatagramSocket socket = new DatagramSocket(10000);
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        socket.receive(packet);
        byte[] bytes = packet.getData();
        System.out.println(new String(bytes,0,packet.getLength()));
        System.out.println("server1");
        socket.close();
    }
}
