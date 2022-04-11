package sort;

import java.util.Arrays;

/**
 * 插入排序-希尔排序
 * 时间复杂度：O(n^1025)
 * 空间复杂度：O(1)
 * 不稳定
 * description
 * Author: HP
 * Date: 2022/3/17
 * Time: 21:27
 */
public class ShellSort {

    public static void main(String args[]){
        ShellSort shellSort = new ShellSort();
        int[] array = {5,4,3,2,1};
        System.out.println(Arrays.toString(shellSort.shellSort(array)));
    }

    public int[] shellSort(int [] a){

        int len=a.length;
                 while(len!=0){
                     len=len/2;
                         for(int i=0;i<len;i++) {
                             for (int j = i + len; j < a.length; j += len) {//元素从第二个开始
                                 int k = j - len;//k为有序序列最后一位的位数
                                 int temp = a[j];//要插入的元素
                                         /*for(;k>=0&&temp<a[k];k-=len){
10                         a[k+len]=a[k];
11                     }*/
                                 while (k >= 0 && temp < a[k]) {//从后往前遍历
                                     a[k + len] = a[k];
                                     k -= len;//向后移动len位
                                 }
                                 a[k + len] = temp;
                             }
//        if(a.length > 0){
//            for(int i = a.length/2 ;i<=1;i = i/2){
//
//                for (int j = 0;j < i; j++ ){
//
//                    int current = a[j];
//                    int index = j + i;
//
//                    while(index < a.length && current < a[index]){
//                        a[j] = a[index];
//                        a[index] = current;
//                        index += i;
//                    }
//
//                }
//
//            }
//
//        }

                         }
                         }
                             return a;

    }
}
