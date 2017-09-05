/**
 * Created by gongyuanfeng on 2017/8/30.
 * beat4.94%
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        //回溯递归，向右，向下的次数是固定的。不行！！太慢，DP问题
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = 1;
        for(int j=n-1;0<=j;j--){
            for(int i=m-1;0<=i;i--){
                if(j==n-1&&i==m-1)continue;//不能少
                dp[i][j] = ( (j==n-1)?0:dp[i][j+1] ) + ( (i==m-1)?0:dp[i+1][j] );
            }
        }
        return dp[0][0];
    }
}
