package com.heima.demo09_transer_stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderDemo01 {
    public static void main(String[] args)  {
        try {
            FileInputStream fs = new FileInputStream("jinjieDay11_bufferedStream/src/test13.txt");
            /**
             * 指定 格式，不会乱码
             */
            InputStreamReader isr = new InputStreamReader(fs,"GBK");

            String  str;
            /*while ((str = br.readLine()) != null){
                *//**
                 * 编码格式不一致，会乱码
                 *//*
                System.out.println(str);
            }*/

            /*char[] buffer = new char[1024];
            int len ;
            while ((len = isr.read(buffer))  != -1){
                System.out.println(new String(buffer,0,len));
            }*/


            //把字符输入流转换成高级缓冲字符输入流；
            BufferedReader br = new BufferedReader(isr);
            char[] buffer = new char[1024];
            String str1 ;
            while ((str1 = br.readLine())  != null){
                System.out.println(str1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
