package array;

import java.util.*;

/**
 * 查找一个数组中是否有重复的元素，有的话返回其中某一个重复元素就可
 * description
 * Author: HP
 * Date: 2022/5/3
 * Time: 21:19
 */
public class Duplicate {
    public static void main(String[] args) {

        Duplicate d = new Duplicate();
        int[] a = {1,2,3,4,5,6,4,7,3,6};
        int[] b = {1,2,3,4,5};
//        System.out.println(d.duplicate1(a));
        System.out.println(d.duplicate2(b));
        System.out.println(d.duplicate3(b));

    }

    /**
     * 对数组排序
     * 查看相邻两个元素是否相等
     * @param list
     * @return
     */
    public int duplicate1(int[] list){
        if (list == null){
            return -1;
        }

        Arrays.sort(list);

        for(int i = 0; i < list.length-1; i++){
            if (list[i] == list[i+1]){

                return list[i];
            }
        }

        return -1;
    }

    /**
     *使用set保存数组中的数
     * set集合不允许重复元素
     * 当添加失败时，证明集合中已经出现过该元素，返回结果
     * @param list
     * @return
     */
    public int duplicate2(int[] list){
        if (list == null){
            return -1;
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < list.length; i++){
            if (!s.add(list[i])){

                return list[i];
            }
//            System.out.println(list[i]);
        }

        return  -1;

    }

    /**
     * 利用hashMap
     * @param list
     * @return
     */
    public int duplicate3(int[] list){
        if (list == null){
            return -1;
        }
        Map<Integer,Integer> m = new HashMap<>();

        for (int i = 0 ; i < list.length; i++){
            if (m.containsKey(list[i])){

                return list[i];
            }

            m.put(list[i],1);
        }

        return -1;
    }
}
