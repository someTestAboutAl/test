package dynamic_programming;

/**
 * 正则表达式匹配
 * “.”表示任意一个字符
 * “*”表示它前面的字符可以出现任意次（包括0）
 * 字符串：a-z的字母
 * 模式：a-z的字母，字符.和*
 * description:
 * user:芋头
 * date:2022/5/25
 * time:16:59
 */
public class Match {
    public static void main(String args[]){
        Match m = new Match();
        String s1 = "aad";
        String s2 = "c*a*d";
        System.out.println(m.solution01(s1,s2));

    }

    /**
     * 动态规划
     * 时间：O(mn),空间(mn)
     * m,n分别为 s1 和 s2 的长度
     * @param s1
     * @param s2
     * @return
     */
    public boolean solution01(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        //dp[i][j]表示s1前i个字符和 s2 前j个字符是否匹配
        boolean[][] dp = new boolean[len1+1][len2+1];

        for (int i = 0; i <= len1; i++){
            for (int j = 0; j <= len2; j++){

                if (j == 0){

                    dp[i][j] = (i == 0 ? true : false); //空串匹配

                }else {

                    if (s2.charAt(j-1) != '*'){

                        //在没有 * 的情况下
                        if (i > 0 && (s1.charAt(i - 1) == s2.charAt(j - 1) || s2.charAt(j -1 ) == '.')){
                            dp[i][j] = dp[i-1][j-1]; //如果当前值匹配，则取决于dp[i-1][j-1]是否匹配
                        }

                    }else {

                        //遇到 *

                        if (j >= 2){
                            dp[i][j] |= dp[i][j -2]; //x*相当于忽略不计
                        }


                        //前一位可以匹配
                        if (i >= 1 && j >= 2 && (s1.charAt(i - 1) ==  s2.charAt(j - 2)||s2.charAt(j - 2) == '.')){
                            dp[i][j] |= dp[i-1][j]; //位或运算 dp[i][j] = dp[i][j] | dp[i-1][j]
                        }

                    }
                }
            }
        }
        for (int i = 0; i < dp.length;i++){
            for (int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]+", ");
            }
            System.out.println();
        }
        return dp[len1][len2];
    }

    /**
     * 递归
     * 时间：O(mn),空间(mn)
     * @param s1
     * @param s2
     * @return
     */
//    public boolean solution02(String s1,String s2){}
}
