package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 交换排序-快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 * 不稳定
 * description
 * Author: HP
 * Date: 2022/3/22
 * Time: 17:12
 */
public class QuickSort {
    public static void main(String args[]){
        QuickSort quickSort = new QuickSort();
        int[] array = {45,20,30,50,10,40,15,25,35};
        quickSort.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] a,int low,int high){

        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        int key = a[low];//保存当前点的值（每次队首的值）
        while (i < j){
            //不断向左查找，找到一个小于当前点的键
            while (a[j] >= key && i < j) {
                j--;
            }

            //不断向右查找，找到一个大于当前点的键
            while (a[i] <= key && i <j ){
                i++;
            }

            //交换两个位置的元素，将小于当前点的值放在前面，大于当前点的值放在后面
            if (i < j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        //当i=j时，扫描结束，i所在位置为当前点的正确位置，交换位置
        a[low] = a[i];
        a[i] = key;
        quickSort(a,low,i-1);//对左边尚未排序的点排序
        quickSort(a,i+1,high);//对右边尚未排序的点排序
    }
}
