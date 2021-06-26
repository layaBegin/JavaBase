package com.heima.JDK8_time;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.*;
import java.util.Date;

public class Demo_time {
    public static void main(String[] args) {
       /* LocalTime nowTime = LocalTime.now();
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);
        System.out.println(nowDate.getYear());
        System.out.println(nowDate.getMonth());
        System.out.println(nowDate.getDayOfMonth());
        System.out.println(nowDate.getDayOfWeek());
        System.out.println(nowDate.getDayOfWeek().getValue());*/

        /*LocalDate d1 = LocalDate.of(1989,10,2);
        System.out.println(d1.getDayOfWeek());
        System.out.println(d1.getDayOfYear());*/

        /*System.out.println(nowTime);
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
        Instant is = Instant.now();
        System.out.println(is);*/

        /*//时间不变
        LocalTime t  = LocalTime.now();
        LocalTime t1 = t.minusHours(1);

        System.out.println(t);
        System.out.println(t1);
        System.out.println(t.minusMinutes(1));
        System.out.println(t.minusSeconds(5));

        LocalDate b = LocalDate.of(2018,5,1);
        LocalDate now = LocalDate.now();
        System.out.println(b.isBefore(now));
        System.out.println(b.isAfter(now));*/

        /*MonthDay birthday = MonthDay.of(6,25);
        LocalDate nowDate = LocalDate.now();
        MonthDay nowday = MonthDay.from(nowDate);
        System.out.println(birthday.equals(nowday));*/

        Instant i = Instant.now();//原子钟时间
        System.out.println(i);

        Date d = Date.from(i);//本地时间即中国时间 = 原子钟时间 + 8
        System.out.println(d);
        LocalDate ld = LocalDate.ofInstant(i,ZoneId.systemDefault());//原子钟时间 + 8
        System.out.println(ld);


    }

}
