package com.heima.sort;

import java.util.Arrays;

public class Demo_sort {
    // 冒泡排序
    public static void main(String[] args) {
        /*int[] arr = {3,5,6,2,8,9,1,4,7,0};
        for (int i = 0; i < arr.length  - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+ 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/

        //选择排序
        int[] arr1 = {3,5,6,2,8,9,1,4,7,0};

        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = i; j < arr1.length ; j++) {
                if (arr1[i] > arr1[j]){
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr1));

        int a = getData(arr1,5);
        System.out.println(a);
    }

    /**
     * 二分查找，排序完之后 进行折半查找，和平衡二叉树，红黑树一样
     */

    public static int getData(int[] arr,int data){
        int start = 0;
        int end = arr.length -1;
        int middle = (start + end)/2;
        while (start <= end){
            if ( data > arr[middle]){
                start = middle;
                middle = (start + end)/2;

            }else if (data < arr[middle]){
                end = middle;
                middle = (start + end)/2;

            }else if (data == arr[middle]){
                return middle;
            }

        }
        return -1 ;
    }



}
