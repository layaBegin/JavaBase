package com.heima.demo01_udp;

import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        //发送时不指定端口，JVM 会指定从默认端口发出
        DatagramSocket socket = new DatagramSocket();
        byte[] bytes = "sdf但他认为人员".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),10000);
        socket.send(packet);
        socket.close();
    }
}
