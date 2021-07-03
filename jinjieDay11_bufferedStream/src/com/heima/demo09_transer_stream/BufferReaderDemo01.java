package com.heima.demo09_transer_stream;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferReaderDemo01 {
    public static void main(String[] args)  {
        try (
                FileReader fr = new FileReader("jinjieDay11_bufferedStream/src/test13.txt");
                BufferedReader br = new BufferedReader(fr);
        ){
            String  str;
            while ((str = br.readLine()) != null){
                /**
                 * 编码格式不一致，会乱码
                 */
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
