package com.heima.demo09_transer_stream;

import java.io.*;

public class OutputStreamReaderDemo01 {
    public static void main(String[] args)  {
        try {
            FileOutputStream fo = new FileOutputStream("jinjieDay11_bufferedStream/src/test15.txt");
            /**
             * 指定GBK 格式，会乱码
             */
            OutputStreamWriter isw = new OutputStreamWriter(fo,"GBK");

            String  str;

            //FileWriter fw = new FileWriter("jinjieDay11_bufferedStream/src/test14.txt");
            //把字符输入流转换成高级缓冲字符输入流；
            BufferedWriter bw = new BufferedWriter(isw);

            bw.write("志虑忠纯，是以先帝简拔以遗陛下");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
