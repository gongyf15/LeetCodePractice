/**
 * Created by gongyuanfeng on 2017/9/3.
 * 完全写错了，没这么简单
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        int start1=0, start2=0, start3=0;
        while(start1<s1.length() || start2<s2.length()){
            if(start1==s1.length()){
                if(c3[start3]==c2[start2]){start2++;start3++;continue;}
                else return false;
            }
            if(start2==s2.length()){
                if(c3[start3]==c1[start1]){start1++;start3++;continue;}
                else return false;
            }

            if(c3[start3]==c1[start1])start1++;
            else if(c3[start3]==c2[start2])start2++;
            else return false;

            start3++;
        }
        return start3 == c3.length;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.isInterleave("aa","ab","aaba");
    }
}
