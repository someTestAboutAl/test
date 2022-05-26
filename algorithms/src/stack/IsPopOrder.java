package stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序
 * description:
 * user:芋头
 * date:2022/5/26
 * time:19:51
 */
public class IsPopOrder {

    public static  void main(String args[]){
        IsPopOrder p = new IsPopOrder();
        int [] a=  {};
        int [] b = {};
        System.out.println();
        System.out.println();
    }

    /**
     * 辅助栈
     * 时间：O(n),空间：O(n)
     * @param pushA
     * @param popA
     * @return
     */
    public boolean solution01(int[] pushA,int[] popA){
        int n = pushA.length;
        Stack<Integer> s = new Stack<>();
        int i = 0;//指向弹出序列

        //将pushA按照顺序入栈
        for (int j = 0; j < n; j++){
//            while (i < n && (s.isEmpty() || s.peek() != popA[j])){
//                s.push(pushA[i]);
//                i++;
//            }
//
//            if (s.peek() == popA[j]){
//
//                s.pop();
//            }else {
//                return false;
//            }
            s.push(pushA[j]);

            while (i < n && !s.isEmpty() && s.peek() == popA[i]){
                s.pop();
                i++;
            }
        }

//        return true;
        return  s.isEmpty();
    }

    /**
     * 原地栈
     * 时间：O(n),空间：O(1)
     * @param pushA
     * @param popA
     * @return
     */
    public boolean solution02(int[] pushA,int[] popA){

        int n = 0; //当前已入栈的大小
        int i = 0; //指向弹出序列popA

        //pushA按照顺序模拟入栈
        for (int j = 0; j < pushA.length; j++){

            int num = pushA[j];

            pushA[n] = num;

            while (n >= 0 && pushA[n] == popA[i]){

                i++;
                n--;
            }

            n++;
        }

        return n==0;
    }
}
