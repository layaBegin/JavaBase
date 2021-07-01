package com.heima.demo03_charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * ASCII字符集：美国信息交换标准代码：包括了数字、英文、符号。
 * GBK：window系统默认的码表。兼容ASCII码表，也包含了21003个汉字，汉字以2个字节存储
 * Unicode码表中的数字不是直接以二进制的形式存储到计算机的，会先通过UTF-8，UTF-16，以及 UTF-32的编码成二进制后再存储到计算机，其中最为常见的就是UTF-8
 * Unicode 中汉字以3个字节存储
 * Unicode是万国码，以UTF-8编码后一个中文一般以三个字节的形式存储。
 * UTF-8也要兼容ASCII编码表。
 * 技术人员都应该使用UTF-8的字符集编码。
 * 编码前和编码后的字符集需要一致，否则会出现中文乱码。
 */
public class Demo_charSet {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "100year建党";

        //---转为编码---
        byte[] bytes = name.getBytes();//默认以UTF-8 解码
        System.out.println(bytes.length);
        byte[] bytes1 = name.getBytes("GBK");
        System.out.println(bytes1.length);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));

        //---解码
        String s = new String(bytes);
        String s1 = new String(bytes1);
        System.out.println(s);
        System.out.println(s1);//乱码
        String s2 = new String(bytes1,"GBK");
        System.out.println(s2);
    }
}
