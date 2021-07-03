package com.heima.demo07_print_stream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo_PrintStream {
    public static void main(String[] args) throws Exception {
        /**
         * 最好用
         */
        PrintStream ps = new PrintStream("jinjieDay11_bufferedStream/src/test16.txt");
        ps.println(1);
        ps.println("sdafas分公司");
        ps.println('d');
        ps.println(97);
        ps.close();
    }
}
