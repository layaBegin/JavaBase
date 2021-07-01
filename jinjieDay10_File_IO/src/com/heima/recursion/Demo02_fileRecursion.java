package com.heima.recursion;

import java.io.File;

public class Demo02_fileRecursion {
    public static void main(String[] args) {
        //c盘中找到AlibabaProtect.exe
        searchFile("C:/","AlibabaProtect.exe");


    }
    public static void searchFile(String path,String name){
        File f = new File(path);
        File[] files = f.listFiles();
        if (files != null && files.length > 0){
            for (File file : files) {
                if (file.isFile()){
                    if (file.getName().equals(name)){
                        System.out.println(file.getAbsolutePath());
                    }
                }else {
                    searchFile(file.getPath(),name);
                }
            }
        }
    }
}
