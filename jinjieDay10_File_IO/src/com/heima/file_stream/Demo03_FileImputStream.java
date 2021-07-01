package com.heima.file_stream;

import java.io.File;
import java.io.FileInputStream;

/**
 * 字节流天生不适合读取字符，会乱码或者 readAllBytes（） 内存溢出
 * 但是适合拷贝
 */
public class Demo03_FileImputStream {
    public static void main(String[] args) throws Exception {
       /* File file = new File("jinjieDay10_File_IO/src/test.txt");
        FileInputStream fs = new FileInputStream(file);
        System.out.println(file.length());
        //一桶水装满
        byte[] bytes = new byte[(int)file.length()];
        int l =  fs.read(bytes);
        String s = new String(bytes);
        System.out.println(s);*/

        FileInputStream fs = new FileInputStream("jinjieDay10_File_IO/src/test.txt");
        byte[] bytes = fs.readAllBytes();
        System.out.println(new String(bytes));

    }
}
