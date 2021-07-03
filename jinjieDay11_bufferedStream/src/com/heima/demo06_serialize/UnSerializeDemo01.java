package com.heima.demo06_serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UnSerializeDemo01 {
    public static void main(String[] args)  {
        try (
                ObjectInputStream os = new ObjectInputStream(new FileInputStream("jinjieDay11_bufferedStream/src/obj-test.txt"));

                ){
            User u =   (User)os.readObject();
            System.out.println(u);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

