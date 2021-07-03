package com.heima.demo01_file;

import java.io.File;

public class Demo02_FileAPI {
    public static void main(String[] args) {
        /*File f = new File("jinjieDay10_File_IO/src/test1.txt");
        try {
            //创建文件夹，几乎不用，写文件的时候会自动创建
            System.out.println(f.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*File f2 = new File("E:/code/下载");
        System.out.println(f2.mkdir());//没有则创建，返回true，否则返回false
*/
        /**
         * 多级文件夹用 mkdirs()
         */
       /* File f3 = new File("E:/code/aaa/g/d");
        System.out.println(f3.mkdirs());//*/

       /* //删除文件
        File f4 = new File("jinjieDay10_File_IO/src/test1.txt");
        System.out.println(f4.delete());//*/
        //可以删除空文件夹 但是不能删除非空文件夹
        File f5 = new File("E:/code/aaa/g");
        System.out.println(f5.delete());

    }
}
