package com.heima.file_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OutputSream01 {
    public static void main(String[] args) throws Exception {
        //写文件，不一定要创建文件
        //OutputStream os = new FileOutputStream("jinjieDay10_File_IO/src/test1.txt");//覆盖文件，
        OutputStream os = new FileOutputStream("jinjieDay10_File_IO/src/test1.txt",true);//追加文件，

        os.write(97);//a
        os.write('b');//
        //os.write('和');//乱码 ，因为write 会当他是一个字节
        //但可以转为字节数组再写
        os.write("我爱你中国".getBytes(StandardCharsets.UTF_8));
        os.write("\r\n".getBytes(StandardCharsets.UTF_8));//换行 \r\n 兼容性更好
        os.write("我爱你中国".getBytes(StandardCharsets.UTF_8),0,9);

        //out.flush();//刷新数据到文件中，流可以继续使用，
        os.close();//用完之后流一定要刷新或关闭，否则会一直占用内存，而且不会写入
    }
}
