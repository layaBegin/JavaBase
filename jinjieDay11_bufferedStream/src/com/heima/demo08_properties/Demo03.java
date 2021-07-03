package com.heima.demo08_properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("jinjieDay11_bufferedStream/src/people.txt"));
        if (properties.containsKey("李方")){
            properties.setProperty("李方","18");
        }
       properties.store(new FileWriter("jinjieDay11_bufferedStream/src/people.txt"),"sadf");
    }
}
