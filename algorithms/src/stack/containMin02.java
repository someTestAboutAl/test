package stack;

import java.util.Stack;

/**
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 * 时间：O(1),空间：O(1)
 * description:
 * user:芋头
 * date:2022/5/26
 * time:18:53
 */
public class containMin02 {

    Stack<Integer> s = new Stack<>();
    int min = 0;

    public void push(int node){

        if (s.isEmpty()){
            min = node;
        }

        s.push(node - min);

        if (min > node){
            min = node;
        }

    }

    public void pop(){
        if (!s.isEmpty()){
            int val = s.pop();
            if (val < 0){
                min = min - val;//当前删除的值为最小值，将最小值还原为删除当前点之后的最小值
            }
        }
    }

    public int top(){
        int val = s.peek();
        if (val < 0){
            return  min;
        }else {
            return min+val;//还原当前值
        }
    }

    public int min(){

        return min;
    }
}
