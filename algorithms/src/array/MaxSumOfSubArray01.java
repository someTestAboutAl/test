package array;

import dynamic_programming.MaxProfit01;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整型数组
 * 找到一个具有最大和的连续子数组，返回最大和
 *
 * 子数组最小长度为 1
 * 要求：
 * 空间：O(n) 时间：O(n)
 * 空间：O(1) 时间：O(n)
 * description
 * Author: HP
 * Date: 2022/5/9
 * Time: 19:30
 */
public class MaxSumOfSubArray01 {
    public static void main(String[] args) {
        MaxSumOfSubArray01  s = new MaxSumOfSubArray01();
        int[] a = {1,-2,3,10,-4,7,2,-5}; // 3,10,-4,7,2; 18
        int[] b = {-10};
        System.out.println(s.solution1(b));
        System.out.println(s.solution2(b));

    }

    /**
     * 动态规划
     * 空间：O(n) 时间：O(n)
     * @param a
     * @return
     */
    public int solution1(int [] a){

        int len = a.length;
        int max = a[0]; // 记录最大和
        int[] sumList  = new int[len];
        sumList[0] = a[0]; //记录到每个节点子串和
        for (int i = 1; i < len; i++){

            sumList[i] = Math.max(a[i],sumList[i-1]+a[i]);
            max = Math.max(max,sumList[i]);

        }
        return max;
    }


    /**
     *动态规划-改进
     * 空间：O(1) 时间：O(n)
     * @param a
     * @return
     */
    public int solution2(int [] a){

        int sum = 0;
        int max = a[0];

        for (int i = 0; i < a.length; i++){

            sum = Math.max(sum + a[i],a[i]);
            max = Math.max(max,sum);
        }

        return max;
    }

}
