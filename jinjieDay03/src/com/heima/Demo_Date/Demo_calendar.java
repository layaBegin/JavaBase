package com.heima.Demo_Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo_calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
       /* System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+6);
        System.out.println(c.get(Calendar.HOUR));*/

        //c.set(Calendar.YEAR,2089);
        c.add(Calendar.DAY_OF_YEAR,10);
        System.out.println(c.get(Calendar.MONTH)+1);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));

        Date d  = c.getTime();//拿的日期
        Date d1 = new Date();
        System.out.println(d);//拿的时间毫秒值
        System.out.println(d1.getTime());
        System.out.println(c.getTimeInMillis());

    }
}
