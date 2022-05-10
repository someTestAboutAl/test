package array;

import java.util.Arrays;

/**
 * 各定一个长度为 n 的整型数组
 * 找到一个具有最大和的连续子数组
 * 存在多个最大和的子数组，返回长度最长的
 * 子数组最小长度为 1
 * 要求：
 * 空间：O(n) 时间：O(n)
 * 空间：O(1) 时间：O(n)
 * description
 * Author: HP
 * Date: 2022/5/9
 * Time: 19:30
 */
public class MaxSumOfSubArray02 {
    public static void main(String[] args) {
        MaxSumOfSubArray02  s = new MaxSumOfSubArray02();
        int[] a = {1,-2,3,10,-4,7,2,-5}; // 3,10,-4,7,2
        System.out.println(Arrays.toString(s.solution1(a)));

    }

    /**
     * 动态规划
     * 空间：O(n) 时间：O(n)
     * @param a
     * @return
     */
    public int[] solution1(int [] a){

        int[] sumList  = new int[a.length];
        sumList[0] = a[0]; //记录到每个节点最大的子串和
        int sum = a[0]; //最大和

        int left = 0, l = 0; //当前遍历的子串首，最大子串首
        int right = 0, r = 0; //当前遍历的子串尾，最大子串尾

        for (int i = 1; i < a.length; i++){
            right++;
            sumList[i] = Math.max(sumList[i-1]+a[i],a[i]);

            //当前节点大于最大子串和，修改当前遍历的子串首节点到当前节点
            if (sumList[i-1]+a[i] < a[i]){
                left = right;
            }

            //出现新的最大和或者最大和相等但子数组更长
            if (sumList[i] > sum || (sumList[i] == sum && (right - left +1) > (r - l + 1))){
                sum = sumList[i];
                l = left;
                r = right;
            }

        }

        int[] res = new int[r - l + 1];
        for (int i = l; i <= r; i++){
            res[i - l] = a[i];
        }

        return res;
    }


    /**
     *动态规划-改进
     * 空间：O(1) 时间：O(n)
     * @param a
     * @return
     */
    public int[] solution2(int [] a){
        int p = a[0];
        int q = 0;
        int sum = p;

        int left = 0, l = 0;
        int right = 0, r = 0;

        for (int i = 0; i < a.length; i++){
            right++;
            q= Math.max(p + a[i],a[i]);

            if (p + a[i] < a[i]){
                left = right;
            }

            //出现新的最大和或者最大和相等但子数组更长
            if (q > sum || (q == sum && (right - left +1) > (r - l + 1))){
                sum = q;
                l = left;
                r = right;
            }

            p = q;

        }

        int[] res = new int[r - l + 1];
        for (int i = l; i <= r; i++){
            res[i - l] = a[i];
        }

        return res;
    }

}
