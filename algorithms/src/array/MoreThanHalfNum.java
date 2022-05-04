package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 * Author: HP
 * Date: 2022/5/4
 * Time: 10:46
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        MoreThanHalfNum halfNum = new MoreThanHalfNum();
        int[] a1 = {1,2,3,2,2,2,5,4,2};//2
        int[] a2 = {3,3,3,3,2,2,2};//3
        int[] a3 = {1,2,3,4,5};//-1
        int[] a4 = {2,2,3,2,4,2,5,2,3,2};//2
        int[] a5 = {2,3,2,1,4};//-1
//        System.out.println(halfNum.solution1(a1));
//        System.out.println(halfNum.solution1(a2));
//        System.out.println(halfNum.solution1(a3));
//        System.out.println(halfNum.solution2(a1));
//        System.out.println(halfNum.solution2(a2));
//        System.out.println(halfNum.solution2(a3));
        System.out.println(halfNum.solution3(a1));
        System.out.println(halfNum.solution3(a2));
        System.out.println(halfNum.solution3(a3));
        System.out.println(halfNum.solution3(a4));
        System.out.println(halfNum.solution3(a5));

    }

    /**
     * 利用hashMap 记录每个数字出现的次数
     * 时间：O(n),空间：O(n)
     * @param a
     * @return
     */
    public int solution1(int[] a){
        if (a == null){
            return -1;
        }

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++){
            int count = m.containsKey(a[i])?m.get(a[i])+1:1;
            m.put(a[i],count);
            if (m.get(a[i]) > a.length/2){
                return a[i];
            }
        }

        return -1;
    }

    /**
     * 排序，若要求的数存在，肯定在数组中间的位置
     * 时间：O(nlogn),空间：O(1)
     * @param a
     * @return
     */
    public int solution2(int[] a){
        if (a == null){
            return -1;
        }

        Arrays.sort(a);
        int res = a[a.length/2];
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] == res){
                count++;
            }

            if (count > a.length/2){
                return a[res];
            }
        }
        return -1;
    }

    /**
     * 投票算法
     * 时间：O(n),空间：O(1)
     * @param a
     * @return
     */
    public int solution3(int[] a){
        if (a == null){
            return -1;
        }

        int condidate = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++){
            if (a[i] == condidate){
                count++;
            }else {
                count--;
            }

            if (count == 0){
                condidate = a[i];
                count++;
            }
        }

        count = 0;

        for (int i = 0; i < a.length; i++){
            if (a[i] == condidate){
                count++;
            }

            if (count > a.length/2){
                return condidate;
            }
        }

        return -1;
    }
}
