package tree;

import java.util.*;

/**
 * 输入一个整数数组，
 * 判断该数组是否为二叉搜索树的后序遍历结果
 * 中序-从小到大
 * description
 * Author: HP
 * Date: 2022/4/26
 * Time: 10:10
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        VerifySquenceOfBST v = new VerifySquenceOfBST();
//        int[] s = {5,7,6,9,11,10,8};
        int[] s ={};
        System.out.println(v.verifySquenceOfBST1(s));
        System.out.println(v.verifySquenceOfBST2(s));
        System.out.println(v.verifySquenceOfBST3(s));


    }

    /**
     * 中序入栈
     * 判断后序序列是否为一个合理的出栈序列
     * @param s
     * @return
     */
    public boolean verifySquenceOfBST1(int[] s){
        if (s.length == 0 || s == null){
            return false;
        }

        List<Integer> m  = new ArrayList<>();
        for (int i = 0; i < s.length; i++){
            m.add(s[i]);
        }
        Collections.sort(m);
//        System.out.println(s);
//        System.out.println(m);
        return isPopOrder(m,s);
    }

    /**
     * 分别判断左子树、右子树、根
     * @param s
     * @return
     */
    public boolean verifySquenceOfBST2(int[] s){
        if (s.length == 0 || s == null){
            return false;
        }

        return check(s,0,s.length-1);

    }


    /**
     *
     * @param s
     * @return
     */
    public boolean verifySquenceOfBST3(int[] s){
        if (s.length == 0 || s == null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;

        for (int i = s.length-1; i >= 0; i--){

            //判断左子树是否小于根节点
            if (s[i] > root){

                return false;
            }

            while (!stack.isEmpty() && stack.peek() > s[i]){
                root = stack.pop();//二叉排序树或其子树的根节点，且其右子树以全部出栈，只需要判断左子树
            }

            stack.push(s[i]);
        }

        return true;
    }

    /**
     * 判断左右子树是否合法
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean check(int[] s,int start,int end){
        if (start >= end){
            return  true;
        }
        int root = s[end];

        int i = end-1;

        while (i >= 0 && s[i] > root ) i--;//得到左右子树的分界点

        //判断左子树是否都小于根节点
        for (int j = start; j <= i; j++){
            if (s[j] > root){
                return false;
            }
        }
        return check(s,start,i) && check(s,i+1,end-1);
    }


    /**
     * 判断s是否为m的一个合法的出栈序列
     * @param m
     * @param s
     * @return
     */
    public boolean isPopOrder(List<Integer> m, int[] s){
        int n = m.size();
        Stack<Integer> stack = new Stack();
        int i = 0, j = 0;
        while (i < n){
            stack.push(m.get(i));
            while (!stack.isEmpty() && stack.peek() == s[j]){
                j++;
                stack.pop();
            }
            i++;
        }

        return j == n;
    }
}
