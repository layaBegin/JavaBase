package com.heima.demo05_tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10071);
        System.out.println("1111");
        Socket accept = ss.accept();


        while (true){
            InputStream inputStream = accept.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            System.out.println(br.readLine());
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
            System.out.println("2222");
        }


        //accept.close();

        //ss.close();

    }
}
