package array;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的奇数放在前面，偶数放在后面,并且奇数（偶数）之间相对位置保持不变
 * 要求：空间：O(n) 时间：O(n)
 * 要求：空间：O(1) 时间：O(n^2)
 * description
 * Author: HP
 * Date: 2022/5/8
 * Time: 16:05
 */
public class ReOrderArray01 {
    public static void main(String[] args) {

        ReOrderArray01 r = new ReOrderArray01();
        int a[] = {1,2,4,5,6,8,7,9};
        System.out.println(Arrays.toString(r.solution1(a)));
        System.out.println(Arrays.toString(r.solution2(a)));
        System.out.println(Arrays.toString(r.solution3(a)));

    }


    /**
     * 排序,利用冒泡排序，每次将奇数提前
     * 空间：O(1) 时间：O(n^2)
     * @param a
     * @return
     */
    public int[] solution1(int[] a){
        if (a == null || a.length == 0){
            return null;
        }

        int odd = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++){
            temp = a[i];
            if (a[i] % 2 == 1){

                for (int j = i; j > odd; j--){
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    temp = a[j-1];
                }
            }else {

                continue;
            }
            odd++;
//            System.out.println("odd:"+ odd);
        }

        return a;
    }

    /**
     * 双指针
     * 空间：O(n) 时间：O(2n)
     * @param a
     * @return
     */
    public int[] solution2(int[] a){
        int len = a.length;
        if (a == null || len == 0){
            return  null;
        }
        int[] res = new int[len];
        int oddNum = 0;
        //统计奇数的个数
        for(int i : a){
            if (i % 2 != 0){
                oddNum++;
            }
        }
        int p = 0; //奇数开始的位置
        int q = oddNum; //偶数开始的位置
        for (int i = 0; i < len; i++){
            if (a[i] % 2 == 0){
                res[q] = a[i];
                q++;
            }else {
                res[p] = a[i];
                p++;
            }
        }

        return res;
    }

    /**
     * 双指针
     * 空间：O(n) 时间：O(n)
     * @param a
     * @return
     */
    public int[] solution3(int[] a){
        int len = a.length;
        if (a == null || len == 0){
            return  null;
        }
        int[] res = new int[len];

        int left = 0; //记录奇数
        int right = len-1; //记录偶数
        int tp_left = left;
        int tp_right = right;
       while (left < len && right >= 0){
           //从左到右遍历一遍，保存所有奇数
            if (a[left] % 2 == 1){
                res[tp_left] = a[left];
                tp_left++;
            }
            left++;
            //从右到左遍历一遍，保存所有偶数
            if (a[right] % 2 == 0){
                res[tp_right] = a[right];
                tp_right--;
            }

            right--;
        }

        return res;
    }
}
