package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个长度为 n 的数组 nums
 * 和滑动窗口的大小 size
 * 找出所有滑动窗口里数值的最大值
 * 时间：O(n),空间：O(n)
 * 例如：输入：[2,3,4,2,6,2,5,1],3
 *      输出：[4,4,6,6,6,5]
 * description:
 * user:芋头
 * date:2022/5/27
 * time:16:20
 */
public class MaxInWindows {

    public static void main(String args[]){
        MaxInWindows w = new MaxInWindows();
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(w.solution01(num,3));
        System.out.println(w.solution02(num,3));

    }

    /**
     * 暴力查找
     * 时间：O(nk),空间：O(1),n 为 数组大小，k 为窗口大小
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> solution01(int[] num, int size){

        ArrayList<Integer> res = new ArrayList<>();

        if (num.length == 0 || size < 1 || size > num.length){
            return res;
        }

        int max = 0;
        for (int i = 0; i < num.length-size+1;i++){
            max = num[i];
            for (int j = i+1; j < i + size; j++){
                max = Math.max(max,num[j]);
            }

            res.add(max);
        }

        return res;
    }

    /**
     * 单调队列
     * 时间：O(n),空间：O(k)
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> solution02(int[] num, int size){

        ArrayList<Integer> res = new ArrayList<>();

        if (num.length == 0 || size < 1 || size > num.length){
            return res;
        }

        LinkedList<Integer>  dq = new LinkedList<>();

        for (int i = 0; i < num.length; i++){

            //判断当前值和当前列表中最后一个值的大小，进行替换，最大值始终在最前面
            while (!dq.isEmpty() && num[i] > num[dq.getLast()]){
                 dq.removeLast();
            }

            dq.addLast(i);

            //确定当前窗口范围，如果当前下标 - 列表中第一个值的下标 >= size ,则表示随着窗口的移动第一个值已经不再当前窗口，将其移出
            if (i - dq.getFirst()+1 > size){
                dq.removeFirst();
            }

            //从第 size 个元素起，开始将最大值放入结果中
            if(i >= size-1){
                res.add(num[dq.getFirst()]);
            }
        }

        return res;
    }

}
