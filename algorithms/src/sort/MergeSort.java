package sort;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 稳定
 * description
 * Author: HP
 * Date: 2022/3/23
 * Time: 19:07
 */
public class MergeSort {

    public static void main(String args[]){

        MergeSort mergeSort = new MergeSort();
        int[] array = {45,20,30,50,10,40,15,25,35};
        mergeSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    //递归
    public void sort(int[] a,int left,int right){
        if(left < right){
            int mid = (right+left)/2;
            sort(a,left,mid);
            sort(a,mid+1,right);
            mergeSort(a,left,right,mid);
        }

    }
    public void mergeSort(int[] a,int left,int right,int mid){
        int[] temp = new int[a.length];
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(a[i]<=a[j]){
                temp[t] = a[i];
                i++;
            }else {
                temp[t] = a[j];
                j++;
            }
            t++;
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = a[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = a[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            a[left++] = temp[t++];
        }

    }

}
