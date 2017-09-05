/**
 * Created by gongyuanfeng on 2017/8/30.
 * 区间DP,200/202,2个超时
 * 为什么超时，是因为用了dp[][],
 * 这里不需要给出范围，故只需要用dp[],dp[i]代表以nums[i]为终点最大的值
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        //区间dp
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = nums[i];
            if(dp[i][i]>max)
                max = dp[i][i];
        }

        //只用到了上三角矩阵
        for(int l=1;l<n;l++){//区间长度
            for(int i=0;i+l<n;i++){
                dp[i][i+l] = Math.max(nums[i]+dp[i+1][i+l],dp[i][i+l-1]+nums[i+l]);
                if(dp[i][i+l]>max)
                    max = dp[i][i+l];
            }
        }

        return max;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println( s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) );
    }
}
