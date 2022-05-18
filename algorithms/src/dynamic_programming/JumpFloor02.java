package dynamic_programming;

/**
 * 一次可以跳一级、两级或者 n 级台阶
 * 跳 n 个台阶一共有几种跳法
 * 要求：空间：O(1) 时间：O(1)
 * description
 * Author: HP
 * Date: 2022/5/18
 * Time: 10:26
 */
public class JumpFloor02 {
    public static void main(String[] args) {
        JumpFloor02 j = new JumpFloor02();
        System.out.println(j.solution01(3));
        System.out.println(j.solution02(3));
        System.out.println(j.solution03(3));

    }

    /**
     * 递归
     * 空间：O(n) 时间：O(n)
     * @param n
     * @return
     */
    public int solution01(int n){
        if (n <= 1){
            return 1;
        }
        return 2*solution01(n-1);
    }

    /**
     * 动态规划
     * f(n) = 2f(n-1)
     * 空间：O(1) 时间：O(n)
     * @param n
     * @return
     */
    public int solution02(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        int res = 1; //n=1
        for (int i = 2; i <= n; i++){

            res *= 2;
        }

        return res;
    }

    /**
     * 公式总结
     * f(n) = 2^(n-1)
     * 空间：O(1) 时间：O(1)
     * @param n
     * @return
     */
    public int solution03(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        return (int) Math.pow(2,n-1);
    }
}
