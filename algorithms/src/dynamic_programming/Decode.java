package dynamic_programming;

import java.util.Arrays;

/**将字母编码成数字（对应二十六个字母）
 * 11--->aa/k
 * 给定一串数字，返回有多少种翻译的结果
 * 0不能编译成任何结果1
 * 要求：空间：O(n) 时间：O(n)
 * description
 * Author: mal
 * Date: 2022/5/18
 * Time: 11:23
 */
public class Decode {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * 空间：O(n) 时间：O(2^n)
     * @param s
     * @return
     */
    public int solution01(String s){

        return recursion01(s.toCharArray(),0);
    }

    public int recursion01(char[] a,int start){
        if (start == a.length){
            return 1;
        }

        if (a[start] == '0'){
            return 0;
        }

        int res1 = recursion01(a,start+1);
        int res2 = 0;
        if (start < a.length-1 && (a[start] == '1' || (a[start] == '2' && a[start+1] <= '6'))){

            res2 = recursion01(a,start+2);
        }

        return res1 + res2;
    }

    /**
     * 0-9
     * 动态规划
     * 11-19
     * 21-26
     * 0
     * 空间：O(n) 时间：O(n)
     * @param s
     * @return
     */
    public int solution02(String s){

        if(s.length() == 0 || s.charAt(0) == '0')
            return 0; // 如果是0则直接返回0
        int[] mydp = new int[s.length()]; // 动态规划思想
        mydp[0] = 1;
        for(int i = 1; i < mydp.length; i++)
        {
            if(s.charAt(i) != '0')
            {
                mydp[i] = mydp[i-1]; // 将当前位置的一个字符进行译码
            }
            int hynum = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0'); // 两个字符合并译码
            if(hynum >= 10 && hynum <= 26)
            {
                if(i == 1) // 如果i为1，则mydp[i]相应加一
                {
                    mydp[i] += 1;
                }
                else
                {
                    mydp[i] += mydp[i-2];
                }
            }
        }
        return mydp[s.length()-1]; // 返回结果即可

    }

    public int solution03(String s) {
            //排除0
            if(s.equals("0"))
                return 0;
            //排除只有一种可能的10 和 20
            if(s == "10" || s == "20")
                return 1;
            //当0的前面不是1或2时，无法译码，0种
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == '0')
                    if(s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')
                        return 0;
            }
            int[] dp = new int[s.length() + 1];
            //辅助数组初始化为1
            Arrays.fill(dp, 1);
            for(int i = 2; i <= s.length(); i++){
                //在11-19，21-26之间的情况
                if((s.charAt(i - 2) == '1' && s.charAt(i - 1) != '0') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) > '0' && s.charAt(i - 1) < '7'))
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
            return dp[s.length()];
        }

}
