package com.heima.demo01_file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Demo01_File {
    public static void main(String[] args) {
        /**
         * 绝对路径定位
         */
        //File f = new File("E:\\code\\下载.jpg");
        //File f = new File("E:/code/下载.jpg");
       /* File f = new File("E:"+File.separator+"code"+File.separator+"下载.jpg");
        System.out.println(f.length());*/

        /**
         * 相对路径定位,相对工程
         */
        File f2  = new File("jinjieDay10_File_IO/src/test.txt");
        System.out.println(f2.length());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getPath());
        System.out.println(f2.getName());
        long time = f2.lastModified();
        /**
         * 格式化时间
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));


    }
}
