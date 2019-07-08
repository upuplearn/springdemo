package com.example.sortalgorism;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author xyys
 * @version 1.0
 * @description com.example.sortalgorism
 * @date 2019/7/7 0007
 */
public class Sort {
    public static void main(String[] args) {
        //int[] arr={1,44,222,8,5,0,66,3,123,53};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = new Random().nextInt(80000);
        }
        Date date = new Date();
        SimpleDateFormat st = new SimpleDateFormat("yyyy MM dd hh mm ss");
        System.out.println("排序前时间" + st.format(date));
        //冒泡排序
        //  bubbleSort(arr);
        //选择排序
        selectSort(arr);
        Date date2 = new Date();
        System.out.println("排序后时间" + st.format(date2));
    }

    private static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            //    System.out.println("第"+i+"次排序"+ Arrays.toString(arr));
        }
        //    System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void selectSort(int[] arr) {
        // int[] arr={1,44,222,8,5,0,66,3,123,53};
       /* for(int i=0;i<arr.length;i++){
            int min =i;
            for(int j=0;j<arr.length;j++){
                if (arr[j]>arr[min]){
                    min=j;
                }
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
            }
        }*/
        //改造后
        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minindex = j;
                }
            }
            if (minindex != i) {
                arr[minindex] = arr[i];
                arr[i] = min;
            }
        }
        // System.out.println(Arrays.toString(arr));
        //  return arr;
    }
}
