package stack;

import java.util.Stack;

/**
 * 输入："nowcoder. a am I"
 * 输出："I am a nowcoder."
 * 进阶：空间复杂度 O(n)，时间复杂度 O(n)
 * description:
 * user:芋头
 * date:2022/5/25
 * time:21:06
 */
public class ReverseSentence {
    public static void main(String args[]){
        ReverseSentence r = new ReverseSentence();
        String s = "nowcoder. a am I";
        System.out.println(r.solution01(s));
        System.out.println(r.solution02(s));

    }

    /**
     * 栈
     * 空间 O(n)，时间 O(n)
     * @param s
     * @return
     */
    public String solution01(String s){

        Stack<String> stack = new Stack<>();
        String[] temp = s.split(" ");
        for (int i = 0; i < temp.length; i++){
            stack.push(temp[i]);
            stack.push(" ");
        }

        StringBuilder res = new StringBuilder();

        if (!stack.isEmpty()){
            stack.pop();//去掉最后一个空格
        }

        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.toString();
    }

    /**
     * 两次反转
     * 空间 O(1)，时间 O(n)
     * @param s
     * @return
     */
    public String solution02(String s){
        int n = s.length();
        char c[] = s.toCharArray();
        reverse(c, 0, n-1);

        for (int i = 0; i < n; i++){
            int j = i;
            while (j < n  && c[j] != ' '){
                j++;
            }

            reverse(c,i,j-1);
            i = j;
        }

        return new String(c);
    }

    public void reverse(char[] c, int l, int h ){

        while (l < h){
            swap(c, l++, h--);
        }
    }

    public void swap(char[] c, int l, int h){
        char temp = c[l];
        c[l] = c[h];
        c[h] = temp;
    }
}