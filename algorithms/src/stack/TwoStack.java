package stack;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 * 使用n个元素来完成 n 次在队列尾部插入整数(push)和
 * n次在队列头部删除整数(pop)的功能
 * 队列中的元素为int类型
 * 时间：O(1),空间(1)
 * description:
 * user:芋头
 * date:2022/5/25
 * time:20:51
 */
public class TwoStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node){

        s1.push(node);
    }

    public int pop(){
        if (s2.size() <= 0){
            while (s1.size() != 0){
                s2.push(s1.pop());
            }
        }
       return s2.pop();
    }



}
