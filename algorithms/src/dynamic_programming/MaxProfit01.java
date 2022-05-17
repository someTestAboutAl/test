package dynamic_programming;

/**
 * 买股票的最好时机
 * 给定一个数组，长度为 n，数组表示第 i 天股票的价格
 * 返回卖股票能获得的最大收益
 * 可以买入和卖出各一次，且买入必须在卖出之前
 * 要求：空间：o(1)，时间:(n)
 * description
 * Author: HP
 * Date: 2022/5/16
 * Time: 10:14
 */
public class MaxProfit01 {
    public static void main(String[] args) {
        MaxProfit01 p = new MaxProfit01();
        int[] prices = {8,9,2,5,4,7,1}; //5
        int[] prices1 = {3,2,1}; // 0
        System.out.println(p.solution1(prices1));
        System.out.println(p.solution2(prices1));
        System.out.println(p.solution3(prices1));

    }

    /**
     * 双循环
     * 空间：o(1)，时间:(n^2)
     * @param prices
     * @return
     */
    public int solution1(int[] prices){
        int max = 0;

        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > max){
                    max = profit;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划-求到第 i 天的最大收入（i = 1,2，……，n）
     * 空间：o(n)，时间:(n)
     * @param prices
     * @return
     */
    public int solution2(int[] prices){
        if (prices == null || prices.length == 0){
            return 0;
        }

        int len = prices.length;
        int dp[] = new  int[len];  //保存到第 i 天为止能够获得的最大收益
        int min = prices[0];  //保存到第 i 天为止出现的最低价格
        for (int i = 0; i < len; i++){
            if (prices[i] < min){

                min  = prices[i];
            }

            if (i == 0){
                dp[i] = 0;
            }else {
                dp[i] = Math.max(dp[i-1],prices[i] - min); //比较（当天价格 - 当前历史最低价格）与（到前一天为止能够获得的最大收益），选择较大的作为当前天的收益
            }
        }

        return dp[len - 1];
    }

    /**
     * 贪心
     * 空间：o(1)，时间:(n)
     * @param prices
     * @return
     */
    public  int solution3(int[] prices){
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE; //到当前位置最小的收益
        int maxP = 0;  //保存最大收益
        for (int i = 0; i < prices.length; i++){
            //更新最小收益
            if (prices[i] < min){
                min = prices[i];
            }
            //比较（当天价格 - 当前历史最低价格）与（最大收益），更新最大收益
            if (prices[i] - min > maxP){
                maxP = prices[i] - min;
            }
        }

        return maxP;
    }
}
