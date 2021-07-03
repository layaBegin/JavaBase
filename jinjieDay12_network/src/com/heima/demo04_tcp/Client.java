package com.heima.demo04_tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //发送时不指定端口，JVM 会指定从默认端口发出
        Socket socket = new Socket("127.0.0.1",10071);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("asdfds".getBytes(StandardCharsets.UTF_8));

        socket.close();
    }
}
