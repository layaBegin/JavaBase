package com.heima.file_char_stream;

import java.io.FileReader;

/**
 * 字符流读写文本不会乱码
 */
public class Demo02_FileReader {
    public static void main(String[] args) throws Exception {
        FileReader fs = new FileReader("jinjieDay10_File_IO/src/test.txt");
        char[] buffer = new char[1024];

        int ch;
        while((ch = fs.read(buffer)) != -1) {
            System.out.print(new String(buffer,0,ch));
        }
    }
}
