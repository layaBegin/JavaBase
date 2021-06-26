package com.heima.JDK8_time;

import java.time.Duration;
import java.time.LocalDateTime;

public class Demo_Duration {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2021,6,26,1,02,00,00);
        LocalDateTime now = LocalDateTime.now();
        Duration du = Duration.between(dt,now);
        System.out.println(du.toDays());
        System.out.println(du.toHours());
        System.out.println(du.toMinutes());
        System.out.println(du.toSeconds());
        System.out.println(du.toMillis());//两个时间差的毫秒值
        System.out.println(du.toNanos());//两个时间差的纳秒之
    }
}
