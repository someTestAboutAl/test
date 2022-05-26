package stack;

import java.util.Stack;

/**
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 * 时间：O(1),空间：O(n)
 * description:
 * user:芋头
 * date:2022/5/26
 * time:18:53
 */
public class containMin {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node){

        s1.push(node);
        if (s2.isEmpty() || node < s2.peek()){
            s2.push(node);
        }else {

            s2.push(s2.peek());
        }


    }

    public void pop(){

        s1.pop();
        s2.pop();
    }

    public int top(){

        return  s1.peek();
    }

    public int min(){

        return s2.peek();
    }
}
