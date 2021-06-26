package com.heima.JDK8_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo_DateTimeFormatter {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate d = LocalDate.now();
        String s = formatter.format(d);
        String s1 = d.format(formatter);
        System.out.println(s);
        System.out.println(s1);

        //解析时间
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s2 = "2021-03-25 13:34:54";
        LocalDateTime dt = LocalDateTime.parse(s2,formatter1);
        System.out.println(dt);
    }
}
