package array;

import java.util.Arrays;

/**
 *
 * 给定一个数组，将数组中的奇数放在前面，偶数放在后面，有相同元素
 * 要求：空间：O(1) 时间：O(n)
 *
 * description
 * Author: HP
 * Date: 2022/5/8
 * Time: 17:09
 */
public class ReOrderArray02 {
    public static void main(String[] args) {

        ReOrderArray02 r = new ReOrderArray02();
        int a[] = {1,2,4,4,5,6,7,8,7,9};
        int b[] = {1,3,5,6,7};
        System.out.println(Arrays.toString(r.solution1(a)));

    }

    /**
     *双指针交换
     * @param a
     * @return
     */
    public int[] solution1(int[] a){
        int len = a.length;
        if (a == null || len == 0){
            return  null;
        }
        int p = 0; //左边
        int q = len - 1; //右边
        while (p < q){
            //方法1
            if (a[p] % 2 == 1){
               p++;
               continue;
            }else {

                while (a[q] % 2 != 1){
                   q--;
                }
                int temp = a[p];
                a[p] = a[q];
                a[q] = temp;
                p++;
                q--;
            }

            //方法2
//            if (a[p] % 2 == 1 && a[q] % 2 == 1){
//                p++;
//            }else if (a[p] % 2 == 1 && a[q] % 2 == 0){
//                p++;
//                q--;
//
//            }else if (a[p] % 2 == 0 && a[q] % 2 == 1){
//                int temp = a[p];
//                a[p] = a[q];
//                a[q] = temp;
//                p++;
//                q--;
//            }else {
//                q--;
//            }


        }
        return a;
    }
}
