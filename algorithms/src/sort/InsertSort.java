package sort;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * 插入排序-直接插入排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定
 * description
 * Author: HP
 * Date: 2022/3/16
 * Time: 21:27
 */
public class InsertSort {
    public static void main(String args[]){
        InsertSort insertSort = new InsertSort();
        int[] array = {5,4,3,2,1};
        System.out.println(Arrays.toString(insertSort.insertSort(array)));
    }

    public int[] insertSort(int [] a){
        if(a.length > 0){
            for(int i = 0 ;i<a.length - 1;i++){
                int current = a[i+1];//保存当前插入的值
                int index = i;
                //获取当前元素的正确位置
                while(index >= 0 && current < a[index]){
                    a[index + 1] = a[index];
                    index--;
                }
                a[index+1] = current;//将当前元素放入正确位置
            }

        }

        return a;

    }

}
