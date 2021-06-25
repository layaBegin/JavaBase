package com.heima.Demo_String;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Demo_string {
    public static void main(String[] args) {
        /**
         * 前提：string 也是 引用类型，引用类型的比较都是比较地址
         */
        /*String s1= "abc";//常量，放在堆内存中的常量池
        String s2 = "abc";//常量，放在堆内存中的常量池,如果有，直接取
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);//由于两个常量相等，堆中只存放一份，所以他们的地址相等
        System.out.println(s3 == s4);//s3,s4 都比较的是堆内存中的地址，都开辟新空间，不相等
        System.out.println(s1 == s3);
        System.out.println(s3);*/

        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2 + "c";
        /**
         * false ,s2 + "c" ,
         * 所有拼接字符串都会转化成StringBuilder
         * 即 s3 = new StringBuilder("abc") 在堆中重新开辟空间，
         * 得到的 新的 地址存放 ”abc“，所以两个地址不相等
         */
        /*System.out.println(s1 == s3);//false
        System.out.println(s1.equals(s3));//true
        String s4 = "ABc";
        System.out.println(s1.equalsIgnoreCase(s4));//true*/

       /* String t1 = "所有拼接字符串都会转化成StringBuilder";
        System.out.println(t1.concat("heheh"));
        System.out.println(t1.length());
        System.out.println(t1.indexOf("拼接"));
        System.out.println(t1.indexOf("rh"));//-1

        System.out.println(t1.substring(2,4));//程序中都是包前不包后
        System.out.println(t1.substring(2));
        System.out.println(t1.charAt(2));
        char[] charArr = t1.toCharArray();
        System.out.println(Arrays.toString(charArr));*/

       /* String r1 = "IloveYou";
        System.out.println(r1.toLowerCase(Locale.ROOT));
        String r2 = "你我日，日落东方，eror";
        System.out.println(r2.replace("我日","**"));
        String r3 = "王安石@刘维，李清照，杜甫";
        String[] arr = r3.split("@");
        //System.out.println(Arrays.toString(arr));
        for (int a = 0; a < arr.length; a++) {
            System.out.println(arr[a]);

        }*/

        String[] arr = {"零","一","二","三","四","五","六","七","八","九"};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号码");
        String phone = sc.nextLine();
        String numCh = "";
        for (int i = 0; i < phone.length(); i++) {
            int t = Integer.valueOf(phone.charAt(i)+ "");
            numCh += arr[t];
        }
        System.out.println(numCh);
    }
}
