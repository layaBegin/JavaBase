package com.heima.JDK8_time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Demo_ChronoUnit {
    public static void main(String[] args) {

        LocalDateTime dt = LocalDateTime.of(2021,6,26,1,02,00,00);
        LocalDateTime now = LocalDateTime.now();
        //最全的，可以比较所有的时间单位
        System.out.println(ChronoUnit.YEARS.between(dt,now));
        System.out.println(ChronoUnit.DAYS.between(dt,now));
        System.out.println(ChronoUnit.MONTHS.between(dt,now));
        System.out.println(ChronoUnit.HOURS.between(dt,now));
        System.out.println(ChronoUnit.MINUTES.between(dt,now));
        System.out.println(ChronoUnit.SECONDS.between(dt,now));
        System.out.println(ChronoUnit.MILLIS.between(dt,now));
    }
}
