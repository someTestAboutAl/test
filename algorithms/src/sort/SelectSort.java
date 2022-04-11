package sort;

import java.util.Arrays;

/**
 * 插入排序-简单选择排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 不稳定
 * description
 * Author: HP
 * Date: 2022/3/21
 * Time: 11:29
 */
public class SelectSort {
    public static void main(String args[]){
        SelectSort selectSort = new SelectSort();
        int[] array = {5,4,3,2,1};
        System.out.println(Arrays.toString(selectSort.selectSort(array)));
    }

    public int[] selectSort(int [] a){
        for(int i = 0; i < a.length-1;i++) {
            //保存当前无序区的最小值
            int min = a[i];//值
            int key = i;//位置
            //查找当前无序区中最小的值
            for (int j = i+1; j < a.length; j++) {
                if (a[j] <= min) {
                    min = a[j];
                    key = j;
                }
            }
            //将无序区第一个值与最小值交换
            a[key] = a[i];
            a[i] = min;
            System.out.println(Arrays.toString(a));
        }

        return a;
    }
}
