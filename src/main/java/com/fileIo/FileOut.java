package com.fileIo;

import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xyys
 * @version 1.0
 * @description com.fileIo
 * @date 2019/7/1 0001
 */
public class FileOut {
    public static void main(String[] args) throws Exception {
        FileOutputStream fo=new FileOutputStream("d:\\fileout2.txt");
        int [][]arr=new int[11][11];
        arr[1][2]=1;
        arr[2][3]=2;
        StringBuilder sb=new StringBuilder();
        for (int[] integers : arr) {
            for (int integer : integers) {
                sb.append(integer+",");
            }
        }
            fo.write(sb.toString().getBytes());
            System.out.println(sb);

        fo.close();
    }
    @Test
    public void fileinput() throws Exception {
        File f=new File("d:\\fileout.txt");
        FileInputStream fi=new FileInputStream(f);
        byte [] data=new byte[(int)f.length()];
       fi.read(data);
       fi.close();
       String s=new String(data);
        String replace = s.replace("[", "").replace("]", "");
        String[] split = replace.split(",");
        //将String数组转成Integer数组
        Integer[] aftIdArray = (Integer[]) ConvertUtils.convert(split, Integer.class);
        for (Integer integer : aftIdArray) {
            System.out.println(integer);
        }
    }

    @Test
    public void fileinput2() throws Exception {
        File f=new File("d:\\fileout2.txt");
        FileInputStream fi=new FileInputStream(f);
        byte [] data=new byte[(int)f.length()];
        fi.read(data);
        fi.close();
        String s=new String(data);
        String[] split = s.split(",");
        //将String数组转成Integer数组
        Integer[] aftIdArray = (Integer[]) ConvertUtils.convert(split, Integer.class);
        int [][]arr=new int[11][11];
        int count=0;
       for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=aftIdArray[count++];
            }
       }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println(Arrays.asList(aftIdArray)+"=="+count);
    }
    @Test
    public void parentFile(){
        File f=new File("C:\\HW_SDK_LOG\\parnoc");
        //获取文件的父目录地址
        System.out.println(f.getParentFile());

    }
}
