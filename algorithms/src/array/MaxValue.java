package array;

/**
 * 礼物最大值
 * m x n的棋盘上每一个格子都放有一定价值的礼物 >0
 * 从左上角开始，每次向右或者向下移动一格，直到棋盘右下角
 * 可以不用管第一行和第一列，从[1,1]开始，每次取上面或者左边最大值然后加上初始点[0,0]的值
 * description
 * Author: HP
 * Date: 2022/5/5
 * Time: 21:56
 */
public class MaxValue {
    public static void main(String[] args) {
        MaxValue m = new MaxValue();
        int[][] g = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(m.solution2(g));
        System.out.println(m.solution1(g));


    }

    /**
     * 动态规划
     * 时间：o(mn),空间：o(1)
     * @param grid
     * @return
     */
    public int solution1(int[][] grid){
        int m = grid.length;//行
        int n = grid[0].length;//列

        for (int i = 1; i < m; i++){
            grid[i][0] += grid[i-1][0];  //初始化第一列的值，与上面价值相加
        }

        for (int i =1 ; i < n; i++){

            grid[0][i] += grid[0][i-1];  //初始化第一行，与左边的价值相加
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);  //到达（i,j）有两条路径，上面或左边，选择两条路径中价值最大的
            }
        }

        return grid[m-1][n-1];
    }


    /**
     * 递归函数
     * @param grid
     * @param m
     * @param n
     * @param dp
     * @return
     */
    public int util(int[][] grid, int m, int n, int[][] dp){
        //到达起点，结束返回
        if (m == 0 && n == 0){
            dp[0][0] = grid[0][0];
//            System.out.println("dp["+ m +"][" + n +"]: "+dp[m][n]);
            return grid[0][0];
        }

        //到达第一行，此时只能往右走
        if (m == 0){
            dp[0][n] = grid[0][n] + util(grid, m,n-1, dp);
        }
        //到达第一列，此时只能往下走
        if (n == 0){
            dp[m][0] = grid[m][0] + util(grid, m-1,n, dp);
        }

        //若dp[m][n]等于0，递归计算到达dp[m][n]是的最大值，递归选择上面和左边中最大值
        if (dp[m][n] == 0){
            dp[m][n] = grid[m][n] + Math.max(util(grid, m-1,n, dp), util(grid, m,n-1, dp));
        }
//        System.out.println("dp["+ m +"][" + n +"]: "+dp[m][n]);

        return dp[m][n];  //若dp[m][n]已经在递归过程中计算过，直接返回其值
    }


    /**
     * 递归
     * 时间：o(mn),空间：o(mn)
     * @param grid
     * @return
     */
    public int solution2(int[][] grid){
        int m = grid.length; //行
        int n = grid[0].length; //列
        int [][] dp = new int[m][n]; //保存递归中间值
        return util(grid, m-1, n-1, dp);
    }
}
