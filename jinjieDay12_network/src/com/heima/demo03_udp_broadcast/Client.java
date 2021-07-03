package com.heima.demo03_udp_broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //发送时不指定端口，JVM 会指定从默认端口发出
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入。。。");
            String s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            /**
             *  广播地址 255.255.255.255
             */
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("255.255.255.255"),10000);
            socket.send(packet);
            if (s.equals("668")){
                break;
            }


        }

        socket.close();
    }
}
