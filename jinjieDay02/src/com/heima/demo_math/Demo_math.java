package com.heima.demo_math;

import java.util.Arrays;

public class Demo_math {
    public static void main(String[] args) {
      /*  System.out.println(Math.ceil(4.0001));//向上取整
        System.out.println(Math.floor(4.9999));//向下取整
        System.out.println(Math.abs(-10));//绝对值
        System.out.println(Math.random());//0.0 -1.0
        System.out.println(Math.round(4.5));//四舍五入
        System.out.println(Math.round(4.4));
        System.out.println(Math.pow(2,4));*/

      /*  //System.exit(0);//JVM 终止
        //1970-1-1 0：00：00 到现在的毫秒值
        long time1 = System.currentTimeMillis();
        System.out.println(time1);
        for (int i = 0;i < 100000;i++){
            System.out.println(i);
        }
        long time2= System.currentTimeMillis();
        System.out.println((time2 - time1)/1000.0 + "");*/


        int[] arr1 = {20,10,30,40,50};
        int[] arr2 = new int[5];
        System.arraycopy(arr1,2,arr2,0,2);
        System.out.println(Arrays.toString(arr2));
    }
}
