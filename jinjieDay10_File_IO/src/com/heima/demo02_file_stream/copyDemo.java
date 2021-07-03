package com.heima.demo02_file_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyDemo {
    public static void main(String[] args) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
             fi = new FileInputStream("E:/code/下载.jpg");
             fo = new FileOutputStream("E:/new.jpg");

            byte[] bytes = new byte[1024];
            int l;
            while ((l = fi.read(bytes))!= -1){
                fo.write(bytes,0,l);
            }


            System.out.println("复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {//无论 是否正常结束还是异常结束，都会走这里，就算前面有return
            try {
                if (fi != null) fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fo != null) fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
