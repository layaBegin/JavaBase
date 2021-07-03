package com.heima.demo02_file_stream;

import java.io.FileInputStream;

public class Demo01_FileImputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream fs = new FileInputStream("jinjieDay10_File_IO/src/test.txt");
        /**
         * read() 一个字节一个字节的读，中文会乱发
         */
        /*int b = fs.read();
        System.out.println((char)b);
        int b1 = fs.read();
        System.out.println((char)b1);
        int b2 = fs.read();
        System.out.println((char)b2);
        int ch
        while((ch = fs.read()) != -1){
        System.out.println((char)ch);
        */





    }
}
