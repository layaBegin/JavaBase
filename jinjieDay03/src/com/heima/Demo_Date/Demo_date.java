package com.heima.Demo_Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Demo_date {
    public static void main(String[] args) {
        /*Date d  = new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        System.out.println(System.currentTimeMillis());

        //请问现在之后150秒是几点；
        long l = System.currentTimeMillis() +150 *1000;
        Date d1 = new Date(l);
        System.out.println(d1);//把时间毫秒值转换成时间*/

        //创建时间格式化对象
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy年MM月dd日 HH-mm-ss");
        String result = sd1.format(d);
        System.out.println(result);
        long l = System.currentTimeMillis() + 150*1000;
        System.out.println(sd.format(l));// 格式化时间毫秒值

    }
}
