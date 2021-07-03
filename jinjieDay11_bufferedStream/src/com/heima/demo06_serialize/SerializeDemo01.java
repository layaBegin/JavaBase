package com.heima.demo06_serialize;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class SerializeDemo01 {
    public static void main(String[] args)  {
        try (
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("jinjieDay11_bufferedStream/src/obj-test.txt"));

                ){
                    os.writeObject(new User("李四",19));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

