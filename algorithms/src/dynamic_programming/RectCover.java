package dynamic_programming;

/**
 * 矩形覆盖
 * 用 n 个 2*1 个小矩形无重叠覆盖 2*n 个大矩形一共有几种方法
 * 要求：空间：O(1) 时间：O(n)
 * f(n) = f(n - 1) + f(n - 2)
 * description
 * Author: mal
 * Date: 2022/5/17
 * Time: 10:08
 */
public class RectCover {
    public static void main(String[] args) {

        RectCover rectCover = new RectCover();
        System.out.println(rectCover.solution01(4));
        System.out.println(rectCover.solution02(4));
    }

    /**
     * 递归
     * 空间：O(n) 时间：O(2^n)
     * @param n
     * @return
     */
    public int solution01(int n){

        if (n <= 2){
            return n;
        }
        return solution01(n-1) + solution01(n -2);
    }

    /**
     * 动态规划
     * 空间：O(n) 时间：O(2^n)
     * @param n
     * @return
     */
    public int solution02(int n){
        if (n <= 2){
            return n;
        }

        int p = 1;
        int q = 2;
        int res = 0;
        for (int i = 3; i <= n; i++){
            res = p + q;
            p = q;
            q = res;
        }

        return res;
    }
}
