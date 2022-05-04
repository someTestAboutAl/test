package array;

import java.util.Arrays;

/**
 * 给定一个数 n
 * 顺序打印从 1 到 最大的 n 位十进制数
 * description
 * Author: HP
 * Date: 2022/5/4
 * Time: 10:29
 */
public class PrintNumbers {
    public static void main(String[] args) {
        PrintNumbers p = new PrintNumbers();
        System.out.println(Arrays.toString(p.print(2)));

    }

    public int[] print(int n){

        if (n <= 0 || n > 5){
            return null;
        }

        int end = (int) Math.pow(10,n);
        int[] res = new int[end-1];
        for (int i = 0 ; i < end-1; i++){

            res[i] = i+1;
        }

        return res;
    }
}
