package com.heima.demo01_char_buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferWriterDemo {
    public static void main(String[] args) throws Exception {
        //写文件，不一定要创建文件
        FileWriter os = new FileWriter("jinjieDay11_bufferedStream/src/test11.txt");//追加文件，
        //FileWriter os = new FileWriter("jinjieDay10_File_IO/src/test1.txt",true);//追加文件，
        BufferedWriter bw = new BufferedWriter(os);
        os.write(97);//a
        os.write('b');//
        os.write("sdfgdfgd 咳咳可前往了");//

        os.close();//用完之后流一定要刷新或关闭，否则会一直占用内存，而且不会写入
    }
}
