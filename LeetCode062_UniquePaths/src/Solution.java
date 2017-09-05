/**
 * Created by gongyuanfeng on 2017/8/30.
 * beat11.6%,和之前的一样
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //回溯递归，向右，向下的次数是固定的。不行！！太慢，DP问题
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = 1;
        for(int j=n-1;0<=j;j--){
            for(int i=m-1;0<=i;i--){
                if(j==n-1&&i==m-1){
                    if(obstacleGrid[i][j]==1)dp[i][j]=0;
                    continue;//不能少
                }
                if(obstacleGrid[i][j]==1)dp[i][j]=0;
                else
                    dp[i][j] = ( (j==n-1)?0:dp[i][j+1] ) + ( (i==m-1)?0:dp[i+1][j] );
            }
        }
        return dp[0][0];
    }
}
