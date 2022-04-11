package sort;

import java.util.Arrays;

/**
 * 交换排序-冒泡排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定
 * description
 * Author: HP
 * Date: 2022/3/22
 * Time: 16:55
 */
public class BubbleSort {
    public static void main(String args[]){
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {45,20,30,50,10,40,15,25,35};
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(array)));
    }

    public int [] bubbleSort(int[] a){

        for(int i = a.length-1; i > 0;i--){
            //两两进行比较，将大的元素往后移动
            for(int j = 0; j < i;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
//            System.out.print("********");
//            System.out.println(Arrays.toString(a));

        }

        return a;
    }
}
