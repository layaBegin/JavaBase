package com.heima.file_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo04_try_resources {
    public static void main(String[] args) {

        try (//只有管道资源能放在这里面 即继承Closeable的，用完后会自动释放，不用再close()
             FileInputStream fi = new FileInputStream("E:/code/下载.jpg");
             FileOutputStream fo = new FileOutputStream("E:/new.jpg");
                ){

            byte[] bytes = new byte[1024];
            int l;
            while ((l = fi.read(bytes))!= -1){
                fo.write(bytes,0,l);
            }
            System.out.println("复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
