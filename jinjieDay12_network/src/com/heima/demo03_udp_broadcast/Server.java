package com.heima.demo03_udp_broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        //接收时要指定端口
        DatagramSocket socket = new DatagramSocket(10000);
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        while (true){
            socket.receive(packet);
            byte[] bytes = packet.getData();
            System.out.println(new String(bytes,0,packet.getLength()));
        }

        //socket.close();
    }
}
