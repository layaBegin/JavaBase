package com.heima.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
       /* int[] arr = {10,8,1,4,5};
        //Arrays.toString();数组转换成字符串
        String str = Arrays.toString(arr);
        System.out.println(str);
        //数组排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));*/
        /*Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入一个数字");
            int a = sc.nextInt();
            arr[i] = a;
        }
        System.out.println(Arrays.toString(arr));*/
        //请出5个 7 到39 的随机数
        int[] arr1 = new int[5];
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int a = r.nextInt(32+1)+7;
            arr1[i] = a;
        }
        System.out.println(Arrays.toString(arr1));
    }
}
