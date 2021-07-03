package com.heima.demo08_properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        //底层是HashTable
        Properties properties = new Properties();
        properties.setProperty("a","dasfsd");
        properties.setProperty("好的","晒太阳人");
        System.out.println(properties);

        properties.store(new FileWriter("jinjieDay11_bufferedStream/src/test17.properties"),"hehe");

    }
}
