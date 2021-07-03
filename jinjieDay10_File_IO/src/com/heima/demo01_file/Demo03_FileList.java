package com.heima.demo01_file;

import java.io.File;
import java.util.Arrays;

/**
 * 英文和数字等在任何国家的字符集中都占1个字节
 * GBK字符中一个中文字符占2个字节
 * UTF-8编码中一个中文1般占3个字节
 * 编码前的字符集和编码好的字符集有什么要求？
 * 必须一致，否则会出现中文字符乱码
 * 英文和数字在任何国家的编码中都不会乱码
 */
public class Demo03_FileList {
    public static void main(String[] args) {
        File f = new File("E:/code");
        //拿一级文件，文件夹的名字
        System.out.println(Arrays.toString(f.list()));
        //拿下一级文件，文件夹
        System.out.println(Arrays.toString(f.listFiles()));

    }
}
