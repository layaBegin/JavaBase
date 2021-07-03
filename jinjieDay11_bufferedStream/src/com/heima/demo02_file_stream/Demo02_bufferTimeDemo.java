package com.heima.demo02_file_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo02_bufferTimeDemo {
    public static final String SRC = "E:\\黑马\\基础班\\day02\\6-课上讲解\\1_字符＋操作.wmv";
    public static final String DIST = "E:\\黑马\\";

    public static void main(String[] args)  {


        //copy1();//1花费时间：297.6s
       // copy2();//2花费时间：0.412s
        //copy3();//3花费时间：0.015s
        copy4();//4花费时间：0.002s



    }

    private static void copy2() {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        try(
                //1,字节输入管道与源文件接通
                FileInputStream fs = new FileInputStream(SRC);
                //2,把低级的字节输入流管道包装成高级的字节缓冲区；
                FileOutputStream fo = new FileOutputStream(DIST + "2.wmv");

        ){
            byte[] bytes = new byte[1024];

            int len ;
            while ((len = fs.read(bytes)) != -1){
                fo.write(bytes,0,len);
            }
            System.out.println("2复制成功");
            endTime = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("2花费时间："+(endTime - startTime)/1000.0 + "s");

    }
    private static void copy1() {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        try(
                //1,字节输入管道与源文件接通
                FileInputStream fs = new FileInputStream(SRC);
                //2,把低级的字节输入流管道包装成高级的字节缓冲区；
                FileOutputStream fo = new FileOutputStream(DIST + "1.wmv");

        ){

            int bt ;
            while ((bt = fs.read()) != -1){
                fo.write(bt);
            }
            System.out.println("复制成功");
            endTime = System.currentTimeMillis();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("1花费时间："+(endTime - startTime)/1000.0 + "s");

    }
    private static void copy3() {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        try(
                //1,字节输入管道与源文件接通
                FileInputStream fs = new FileInputStream("E:/code/下载.jpg");
                //2,把低级的字节输入流管道包装成高级的字节缓冲区；
                FileOutputStream fo = new FileOutputStream("E:/hehe.jpg");
                //3,把字节输出管道与目标文件接通
                BufferedInputStream bi = new BufferedInputStream(fs);
                //4,把低级的字节输出流管道包装成高级的缓冲字节输出管道
                BufferedOutputStream bo = new BufferedOutputStream(fo);
        ){

            int len ;
            while ((len = bi.read()) != -1){
                bo.write(len);
            }
            System.out.println("3复制成功");
            endTime = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("3花费时间："+(endTime - startTime)/1000.0 + "s");
    }
    private static void copy4() {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        try(
                //1,字节输入管道与源文件接通
                FileInputStream fs = new FileInputStream("E:/code/下载.jpg");
                //2,把低级的字节输入流管道包装成高级的字节缓冲区；
                FileOutputStream fo = new FileOutputStream("E:/hehe.jpg");
                //3,把字节输出管道与目标文件接通
                BufferedInputStream bi = new BufferedInputStream(fs);
                //4,把低级的字节输出流管道包装成高级的缓冲字节输出管道
                BufferedOutputStream bo = new BufferedOutputStream(fo);
        ){
            byte[] bytes = new byte[1024];

            int len ;
            while ((len = bi.read(bytes)) != -1){
                bo.write(bytes,0,len);
            }
            System.out.println("3复制成功");
            endTime = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("4花费时间："+(endTime - startTime)/1000.0 + "s");
    }
}
