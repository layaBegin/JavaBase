package com.heima.file_char_stream;

import java.io.FileInputStream;
import java.io.FileReader;

/**
 * 字符流读写文本不会乱码
 */
public class Demo01_FileReader {
    public static void main(String[] args) throws Exception {
        FileReader fs = new FileReader("jinjieDay10_File_IO/src/test.txt");
        /**
         * read() 一个字节一个字节的读，中文会乱发
         */
       /* int b = fs.read();
        System.out.println((char)b);
        int b1 = fs.read();
        System.out.println((char)b1);
        int b2 = fs.read();
        System.out.println((char)b2);*/
        int ch;
        while((ch = fs.read()) != -1) {
            System.out.print((char) ch);
        }
    }
}
