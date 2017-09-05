/**
 * Created by gongyuanfeng on 2017/9/3.
 * beat 90.69%!! DP
 */
public class Solution {
    public int numDecodings(String s) {
        if(s.equals("")) return 0;

        char[] str = s.toCharArray();
        int n = str.length;
        //dp[n]多出来，为了程序简便
        int[] dp = new int[n+1];
        dp[n]=1;
        dp[n-1] = str[n-1]=='0'?0:1;

        for(int i=n-2;0<=i; i--){
            if(str[i]=='0')dp[i]=0;
            else dp[i] = ( ( str[i]-'0' )*10+( str[i+1]-'0' ) ) <= 26? dp[i+1]+dp[i+2]:dp[i+1];
        }

        return dp[0];
    }
}
