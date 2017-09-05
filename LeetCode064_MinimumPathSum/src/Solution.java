/**
 * Created by gongyuanfeng on 2017/8/30.
 * beat9.53%,和之前的一样,区间dp
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        //回溯递归，向右，向下的次数是固定的。不行！！太慢，DP问题
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = grid[m-1][n-1];
        for(int j=n-1;0<=j;j--){
            for(int i=m-1;0<=i;i--){
                if(j==n-1&&i==m-1)continue;

                dp[i][j] = grid[i][j]+ Math.min( (j==n-1)?Integer.MAX_VALUE:dp[i][j+1] ,  (i==m-1)?Integer.MAX_VALUE:dp[i+1][j] );
            }
        }
        return dp[0][0];
    }
}
