package com.heima.file_stream;

import java.io.FileInputStream;

public class Demo02_FileImputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream fs = new FileInputStream("jinjieDay10_File_IO/src/test.txt");
       //定义一个装3个字节的桶
        byte[] buffer = new byte[3];
        int length = fs.read(buffer);
        System.out.println(length);
        String s = new String(buffer);
        System.out.println(s);//abc
        int length1 = fs.read(buffer);
        //String s1 = new String(buffer);//dec
        String s2 = new String(buffer,0,length1);
        //System.out.println(s1);
        System.out.println(s2);//de



    }
}
