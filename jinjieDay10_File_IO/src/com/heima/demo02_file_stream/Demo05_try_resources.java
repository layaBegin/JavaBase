package com.heima.demo02_file_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Demo05_try_resources {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fi = new FileInputStream("E:/code/下载.jpg");
        FileOutputStream fo = new FileOutputStream("E:/new.jpg");

        try (fi;fo){
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
