package com.heima.demo07_print_stream;

import java.io.PrintStream;

public class Demo02_PrintStream {
    public static void main(String[] args) throws Exception {
        System.out.println("十多个人过去而且烹饪");
        System.out.println("杰卡尔net");
        PrintStream out = new PrintStream("jinjieDay11_bufferedStream/src/test17.txt");
        /**
         * 重定向打印位置，默认打印到控制台
         */
        System.setOut(out);
        System.out.println("为日普通京东方微软");

    }
}
