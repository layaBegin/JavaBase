package com.heima.demo06_tcp_reback;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        //发送时不指定端口，JVM 会指定从默认端口发出
        Socket socket = new Socket("127.0.0.1",10071);
        OutputStream outputStream = socket.getOutputStream();
        //outputStream.write("asdfds".getBytes(StandardCharsets.UTF_8));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("asdergdgd");
        bw.flush();//一定要刷新，不然收不到
        socket.shutdownOutput();

        System.out.println("-----下面是客户端接受返回------");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str ;
        while ((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
        socket.close();
    }
}
