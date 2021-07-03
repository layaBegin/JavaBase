package com.heima.demo02_file_stream;

import java.io.*;

public class Demo01_byte_buffer {
    public static void main(String[] args)  {

        try(
                //1,字节输入管道与源文件接通
            FileInputStream fs = new FileInputStream("E:/code/下载.jpg");
            //2,；把字节输出管道与目标文件接通
            FileOutputStream fo = new FileOutputStream("E:/hehe.jpg");
            //3,把低级的字节输入流管道包装成高级的字节缓冲区
            BufferedInputStream bi = new BufferedInputStream(fs);
            //4,把低级的字节输出流管道包装成高级的缓冲字节输出管道
            BufferedOutputStream bo = new BufferedOutputStream(fo);
        ){
            byte[] bytes = new byte[1024];

            int len ;
            while ((len = bi.read(bytes)) != -1){
                bo.write(bytes,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
