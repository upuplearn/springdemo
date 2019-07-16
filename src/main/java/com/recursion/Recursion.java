package com.recursion;

/**
 * @author xyys
 * @version 1.0
 * @description com.recursion
 */
public class Recursion {

    public static void main(String[] args) {
        int i = recursion2(5);
          System.out.println(i);
    }

    //求5的阶层
    public static int recursion2(int n){
        if (n==1){
           return 1;
        }
        return recursion2(n - 1) * n;//*2*3
    }
    //递归
    public static void recursion(int n){
        if (n>1){
            recursion(n-1);
        }
        System.out.println(n);
    }
}
