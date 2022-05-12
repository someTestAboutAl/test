package array;

import java.util.Arrays;

/**
 * 构建乘积数组
 * 输入一个一维数组
 * 构建一个长度相等的数组使其每个位置的元素为除该位置以外其余元素的乘积
 * description
 * Author: HP
 * Date: 2022/5/9
 * Time: 20:11
 */
public class MulArray {
    public static void main(String[] args) {
        MulArray m = new MulArray();
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(m.solution1(a)));
        System.out.println(Arrays.toString(m.solution2(a)));

    }

    /**
     * 分区，双向遍历
     * 空间：O(n) 时间：O(n)
     * @param a
     * @return
     */
    public int[] solution1(int[] a){
        if (a == null || a.length == 0 || a.length == 1){
            return null;
        }
        int[] res = new  int[a.length];
        res[0] = 1;
        //计算每个相应位置左下角所有的值
        for (int i = 1; i < a.length; i++){

            res[i] = res[i-1] * a[i-1];

        }

        int temp = 1;
        //在左下角计算完成的基础上累乘右上角的结果
        for (int i = a.length-1; i >= 0; i--){
            res[i] *= temp;
            temp *= a[i];
        }

        return res;
    }

    /**
     * 动态规划
     * 空间：O(n) 时间：O(n)
     * @param a
     * @return
     */
    public int[] solution2(int[] a){

        if (a == null || a.length == 0 || a.length == 1){
            return null;
        }

        int[] dp = new int[a.length];
        dp[0] = a[1];
        dp[1] = a[0];
        int temp = dp[0] * dp[1];
        for (int i = 2; i < a.length; i++){
            if (a[i] != 1){
                //将第 i 个值与其前面的每一项都相乘
                for (int j = 0; j < i; j++){
                    dp[j] *= a[i];
                }
            }
            //从下标2开始，每个值都与其后面的每个相乘
            dp[i] = temp; // 将当前 i 位置之前所有数据的乘积赋值给它
            temp *= a[i]; //从下标2开始，temp表示每个值之前的所有值相乘
        }
        return dp;
    }
}
