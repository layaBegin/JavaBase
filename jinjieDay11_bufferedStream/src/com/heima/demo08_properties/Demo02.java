package com.heima.demo08_properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Set;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("jinjieDay11_bufferedStream/src/test17.properties"));
        System.out.println(properties);
        Set<String> s = properties.stringPropertyNames();
        for (String s1 : s) {
            System.out.println(properties.getProperty(s1));
        }
        properties.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }
}
