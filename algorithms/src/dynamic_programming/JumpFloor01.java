package dynamic_programming;

/**
 *  一次可以跳一级或者两级台阶
 *  跳 n 个台阶一共有几种跳法
 *  要求：空间：O(1) 时间：O(n)
 * description
 * Author: mal
 * Date: 2022/5/18
 * Time: 10:26
 */
public class JumpFloor01 {
    public static void main(String[] args) {
       JumpFloor01 j = new JumpFloor01();
       System.out.println(j.solution01(11));
        System.out.println(j.solution02(11));

    }

    /**
     * 递归
     * 空间：O(1) 时间：O(2^n)
     * @param n
     * @return
     */
    public int solution01(int n){
        if (n <= 0){
            return -1;
        }
        if (n < 3 && n > 0){
            return n;
        }

        return solution01(n-1)+solution01(n-2);
    }

    /**
     * 动态规划
     * 空间：O(1) 时间：O(n)
     * @param n
     * @return
     */
    public  int solution02(int n){
        if (n <= 0){
            return -1;
        }else if (n < 3 ){
            return n;
        }

//        int res = 0;
//        int stepf = 2;
//        int stepff = 1;
//        for (int i = 3; i <= n; i++){
//            res = stepff + stepf;
//            stepff = stepf;
//            stepf = res;
//
//        }

        //改进
        int stepf = 2;
        int stepff = 1;
        for (int i = 3; i <= n; i++){
            stepf = stepff + stepf;
            stepff = stepf - stepff;

        }

        return stepf;
    }
}
