/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;

        int y = x;
        int len = 0;
        while(y != 0){
            len++;
            y /= 10;
        }
        int tail = 0,head = 0;
        for(int i=1;i<=len/2;i++){
            tail = x%10;
            head = (int) (x%Math.pow(10, len-2*i+2)/Math.pow(10, len-2*i+1));
            //去尾（不能掐头，因为有0）
            x = x/10;

            if(tail != head) return false;
        }
        return true;
    }

}
