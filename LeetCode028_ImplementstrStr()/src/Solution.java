/**
 * Created by gongyuanfeng on 2017/8/23.
 * 找substring
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int lenNeedle = needle.length();
        int lenHay = haystack.length();

        for(int i=0;i<=lenHay-lenNeedle;i++){
            if(needle.equals(haystack.substring(i, i+lenNeedle)))
                return i;
        }
        return -1;
    }

}