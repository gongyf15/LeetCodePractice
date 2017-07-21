/**
 * Created by gongyuanfeng on 2017/7/21.
 * 最优解法是从2n-1个中心分别向外扩散
 */
public class Solution {
    public String longestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s);
        String sR = sb.reverse().toString();
        if(s.equals(sR)) return s;
        int len = s.length();

        int l = 0,r = 0;
        int maxValue = 0,count=0;
        //错位相减
        //可能回文的长度
        for(int i=1;i<=len;i++){
            for(int j=0;j<=len-i;j++){
                if(isPalindromic(s, sR, j, j+i, len)){
                    maxValue = i;
                    l=j;
                    r=j+i;

                    count=0;
                    break;
                }
                else if(j==len-i)
                    count++;
            }
            //不可能有更多回文
            if(count==2)
                break;
        }
        return s.substring(l,r);
    }

    //是否是回文
    private static boolean isPalindromic (String str, String sR, int l, int r,int len){
        String s = str.substring(l,r);
        String sr = sR.substring(len-r,len-l);
        if(s.equals(sr))
            return true;
        else
            return false;
    }


}
