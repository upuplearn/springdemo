package com.example.sortalgorism;

import com.sun.prism.impl.paint.PaintUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xyys
 * @version 1.0
 * @description com.example.sortalgorism
 * @date 2019/7/7 0007
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {1, 44, 222, 8, 5, 0, 66, 3, 123, 53};
       /*int[] arr = new int[20000000];
        for (int i = 0; i < 20000000; i++) {
            arr[i] = new Random().nextInt(80000);
        }*/
        Date date = new Date();
        SimpleDateFormat st = new SimpleDateFormat("yyyy MM dd hh mm ss");
        System.out.println("排序前时间" + st.format(date));
        //冒泡排序
        //  bubbleSort(arr);
        //选择排序
        // selectSort(arr);
        //快速排序
        // int[] ints = quickSort(arr, 0, arr.length - 1);
        //基数排序
        radixSort(arr);
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

    //选择排序
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

    //插入排序
    @Test
    public void insertSort() {
        int[] arr = {1, 3, 6, 9, 22, 6, 66, 16, 26, 25};

        for (int i = 1; i < arr.length; i++) {
            int insertval = arr[i];
            int insertindex = i - 1;
            //insertindex>=0是为了防止索引越界
            while (insertindex >= 0 && insertval < arr[insertindex]) {
                arr[insertindex + 1] = arr[insertindex];
                insertindex--;
            }
            insertindex++;
            arr[insertindex] = insertval;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int arr[], int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            /*if( l >= r) {
                break;
            }*/
            int[] arsr = {1, 2, 3, 4, 5,};
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
          /*  if(arr[l] == pivot) {
                r --;
            }*/
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
           /* if(arr[r] == pivot) {
                l ++;
            }*/
        }
        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
        return arr;
    }

    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }
    //合并的方法

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        t = 0;
        int tempLeft = left;
        //最后一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    @Test
    public void testmergeSort() {
        int[] arr = {1, 3, 7, 5, 2, 9, 6, 66};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(temp));
    }

    //基数排序/桶排序
    public static void radixSort(int[] arr) {
        //根据前面的推导过程，我们可以得到最终的基数排序代码
        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        //这里我们使用循环将代码处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;

            }
            System.out.println("第" + (i + 1) + "轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }
    }

    /* //基数排序/桶排序--个人实践
     public static void radixSort2(int[] arr) {
         int [][]bucket=new int[10][arr.length];
         int []one=new int[10];
         int maxval=arr[0];//寻找最大数
         for (int i = 1; i < arr.length; i++) {
             if (arr[i]>maxval){
                 maxval=arr[i];
             }
         }
         int maxlength=(maxval+"").length();
         for (int i = 0,n=1; i < maxlength; i++,n*=10) {
             for (int j = 0; j < arr.length; j++) {
                 int digitElement=arr[j]/n%10;
                 bucket[digitElement][one[digitElement]]=arr[j];
                 one[digitElement]++;
             }
             int index=0;
             for (int k = 0; k < one.length; k++) {
                 if (one[k]!=0){
                     for (int l = 0; l < one[k]; l++) {
                         arr[index++]=bucket[k][l];
                     }
                 }
                 one[k]=0;
             }
         }
        System.out.println(Arrays.toString(arr));
     }*/
    @Test
    public void testBinarySearch() {
        int[] arr = {1, 3, 5, 9, 66, 86, 86, 86, 86};
        List<Integer> integers = binarySearch(arr, 0, arr.length - 1, 86);
        System.out.println(integers);
    }

    //二分查找，注意二分查找必须是有序的，如果是无序的需要将数组转换成有序的再进行二分查找
    public List<Integer> binarySearch(int[] arr, int left, int right, int findval) {
        //如果左边大于右边，退出递归
      /* if (left>right){
           return -1;
       }
       //获取中间索引
        int mid=(left+right)/2;
       //如果要查找的值大于中间值，说明要往右边递归找
        if (findval>arr[mid]){
          return   binarySearch(arr,mid+1,right,findval);
          //如果要查找的值小于中间值，说明要往左边边递归找
        }else if (findval<arr[mid]){
          return   binarySearch(arr,left,mid-1,findval);
          //否则找到了
        }else {
            return mid;
        }*/
        //当需要查找多个相同的值时
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        if (findval > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findval);
        } else if (findval < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findval);
        } else {
            List<Integer> resIndexlist = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                //如果索引找到了最左边没找到或者值不等于需要查找的值退出循环，否则就将索引添加到集合
                if (temp < 0 || arr[temp] != findval) {
                    break;
                }
                resIndexlist.add(temp);
                temp--;
            }
            resIndexlist.add(mid);
            temp = mid + 1;
            while (true) {
                //如果索引找到了最右边边没找到或者值不等于需要查找的值退出循环，否则就将索引添加到集合
                if (temp > right || arr[temp] != findval) {
                    break;
                }
                resIndexlist.add(temp);
                temp++;
            }
            return resIndexlist;
        }
    }

    @Test
    public void testFibonacci() {
       System.out.println( fibonacci(9));

    }
    public int fibonacci(int i) {
        if (i==0){
            return 1;
        }else if (i==1){
            return 1;
        }
        return fibonacci(i-1)+fibonacci(i-2);
    }
}
