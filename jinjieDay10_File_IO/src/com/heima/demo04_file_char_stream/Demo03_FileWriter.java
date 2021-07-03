package com.heima.demo04_file_char_stream;

import java.io.FileWriter;

/**
 * 字符流读写文本不会乱码
 */
public class Demo03_FileWriter {
    public static void main(String[] args) throws Exception {
        FileWriter fs = new FileWriter("jinjieDay10_File_IO/src/test.txt");
        //追加写入
        //FileWriter fs = new FileWriter("jinjieDay10_File_IO/src/test.txt",true);
        fs.write("我");
        fs.write(97);
        fs.write('d');
        fs.write("1");
        fs.write("\f\n");
        char[] buffer = "字符流读写文本不会乱码".toCharArray();
        fs.write(buffer,0,3);//只写前3个字符
        /*int ch;
        while((ch = fs.write(buffer)) != -1) {
            System.out.print(new String(buffer,0,ch));
        }*/

        fs.close();
    }
}
