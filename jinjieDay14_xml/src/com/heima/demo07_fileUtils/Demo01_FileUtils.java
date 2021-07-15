package com.heima.demo07_fileUtils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Demo01_FileUtils {
    public static void main(String[] args) throws IOException {


        String string = FileUtils.readFileToString(new File("jinjieDay14_xml/src/com/heima/a.txt"),"UTF-8");
        System.out.println(string);
        FileUtils.copyFile(new File("jinjieDay14_xml/src/com/heima/a.txt"),new File("jinjieDay14_xml/src/com/heima/b.txt"));
        FileUtils.copyDirectory(new File("jinjieDay14_xml/src/com/heima/fileUtils"),new File("E:\\黑马\\fileUtils"));
    }
}
