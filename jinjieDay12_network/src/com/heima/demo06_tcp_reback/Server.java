package com.heima.demo06_tcp_reback;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10071);
        System.out.println("服务器接受");
        Socket socket = ss.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str;
        System.out.println(br.readLine());
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }

        System.out.println("----下面是服务器给客户端返回数据----");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("服务器发来问候~");
        bufferedWriter.flush();
        socket.close();

        ss.close();

    }
}
