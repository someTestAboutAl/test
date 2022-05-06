package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组
 * 将数组中的所有数拼起来
 * 打印其中最小的一个数
 * description
 * Author: HP
 * Date: 2022/5/6
 * Time: 17:05
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        PrintMinNumber p = new PrintMinNumber();
        int[] a = {3,32,321};
        System.out.println(p.solution1(a));
//        System.out.println(p.solution2(null));

    }

    /**
     * 排序
     * 空间：o(n)，时间:(nlogn)
     * @param a
     * @return
     */
    public String solution1(int[] a){

        if (a == null || a.length == 0){
            return null;
        }

        String[] s = new String[a.length];

        //转换成字符串
        for (int i = 0; i < a.length; i++){
            s[i] = a[i] + "";
        }
        System.out.println(Arrays.toString(s));

        //重载比较算法
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        System.out.println(Arrays.toString(s));

        //生成字符串
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length; i++){
            res.append(s[i]);
        }

        return res.toString();

    }

    /**
     * 冒泡排序
     * 空间：o(n)，时间:(n^2)
     *
     * @param a
     * @return
     */
    public String solution2(int[] a){

        if (a == null || a.length == 0){
            return null;
        }

        String[] s = new String[a.length];

        //转换成字符串
        for (int i = 0; i < a.length; i++){
            s[i] = a[i] + "";
        }

        for (int i = 0; i < s.length-1; i++){

            for (int j = 0; j < s.length-i-1; j++){
                String s1 = s[j] + s[j +1];
                String s2 = s[j+1] + s[j];
                if (s1.compareTo(s2) > 0){
                    String temp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = temp;
                }
            }

        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length; i++){
            res.append(s[i]);
        }

        return res.toString();

    }
}
