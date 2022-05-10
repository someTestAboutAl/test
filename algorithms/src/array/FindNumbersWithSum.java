package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入一个升序数组和一个数字s
 * 找到两个和为s的数，有多对，返回其中一对
 * description
 * Author: HP
 * Date: 2022/5/10
 * Time: 10:54
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {

    }

    /**
     * 哈希表
     * 空间：O(n) 时间：O(n)
     * @param a
     * @param sum
     * @return
     */
    public List<Integer> solution1(int[] a, int sum){
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < a.length; i++){
            int temp = sum - a[i];
            if (!mp.containsKey(temp)){
                mp.put(a[i],i);
            }else {
                res.add(temp);
                res.add(a[i]);
                break;
            }
        }

        return res;
    }

    /**
     * 双指针
     * 空间：O(1) 时间：O(n)
     * @param a
     * @param sum
     * @return
     */
    public List<Integer> solution2(int[] a, int sum){
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = a.length-1;
        while (left < right){
            if (a[left] + a[right] == sum){
                res.add(a[left]);
                res.add(a[right]);
                break;
            }else if (a[left] + a[right] > sum){
                right--;
            }else {
                left++;
            }
        }

        return res;
    }
}
