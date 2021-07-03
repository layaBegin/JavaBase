package com.heima.demo04_tcp;

import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10071);
        System.out.println("1111");
        Socket accept = ss.accept();
        System.out.println("2222");
        InputStream inputStream = accept.getInputStream();

        int len;
        while ((len = inputStream.read()) != -1){
            System.out.println((char)len);
        }
        accept.close();
    }
}
