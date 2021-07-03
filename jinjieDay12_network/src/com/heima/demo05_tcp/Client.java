package com.heima.demo05_tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws Exception {
        //发送时不指定端口，JVM 会指定从默认端口发出
        Socket socket = new Socket("127.0.0.1",10071);
        //OutputStream outputStream = socket.getOutputStream();
        //outputStream.write("asdfds".getBytes(StandardCharsets.UTF_8));

        /*BufferedWriter br = new BufferedWriter(new OutputStreamWriter(outputStream));
        br.write("asdergdgd");
        br.flush();//一定要刷新，不然收不到*/
//        int num = 0;
        while (true){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("阿斯弗一定要刷新，不然收不到:");
            bw.newLine();
            bw.flush();//一定要刷新，不然收不到
        }
        //socket.close();
    }
}
