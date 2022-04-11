package sort;

import java.util.Arrays;

/**
 * 插入排序-简单选择排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 不稳定
 * description
 * Author: HP
 * Date: 2022/3/21
 * Time: 16:05
 */
public class HeapSort {
    public static void main(String args[]){
        HeapSort heapSort = new HeapSort();
        int[] array = {45,20,30,50,10,40,15,25,35};
//        System.out.println(Arrays.toString(heapSort.heapSort(array)));
        System.out.println(Arrays.toString(heapSort.heapSort(array)));
    }


    public int[] heapSort(int [] a){
        //构造大根堆，交换根节点与最后一个叶节点
        for(int i=a.length-1;i >= 0;i--){
            buildMaxHeap(a,i);
            int key = a[0];
            a[0] = a[i];
            a[i] = key;
        }
        return a;
    }


//    public void buildMaxHeap(int [] a,int lastIndex){
//        for(int i = (lastIndex-1)/2; i >= 0;i--){
//            int leftIndex = i*2+1;
//            int key = a[i];
//            int biggerIndex = leftIndex;
//
//            if(leftIndex+1<= lastIndex && a[leftIndex+1] > a[leftIndex]){
//                   biggerIndex = leftIndex+1;
//                }
//            if(biggerIndex <= lastIndex && key < a[biggerIndex]){
//                    a[i] = a[biggerIndex];
//                    a[biggerIndex] = key;
//                    i = biggerIndex + 1;
//                }
//        }
//    }

    public void buildMaxHeap(int [] a,int lastIndex){
        for(int i = (lastIndex-1)/2; i >= 0;i--){
            int biggerIndex = i*2+1;
            int value = a[i];
            int key = i;
            while (biggerIndex <= lastIndex){
                //记录当前节点左右孩子中较大的
                if(biggerIndex+1<= lastIndex && a[biggerIndex+1] > a[biggerIndex]){
                    biggerIndex++;
                }
                //判断当前根节点是否大于孩子节点。否：交换；是：结束循环
                if(value < a[biggerIndex]){
                    a[key] = a[biggerIndex];
                    //继续向下调整
                    key = biggerIndex;
                    biggerIndex = biggerIndex*2+1;
                }else {
                    break;
                }
            }
            a[key]=value;
//            System.out.println(Arrays.toString(a));
        }
    }
}
