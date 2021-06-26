package com.heima.JDK8_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Demo_Period {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d);
        LocalDate birthday = LocalDate.of(2021,5,2);


        Period  p = Period.between(birthday,d);
        System.out.println(p.getYears());
        System.out.println(p.getMonths());
        System.out.println(p.getDays());
    }
}
