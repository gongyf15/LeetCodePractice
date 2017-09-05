/**
 * Created by gongyuanfeng on 2017/8/23.
 * 超时，如果|divisor|太小，要循环很久
 * 需要用位运算，divisor左移n次就是divisor*2^n
 * 例外情况只有2种，除数为0或者被除数为MIN,除数为-1。
 * 善用Long
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if((divisor == 0)|| (dividend == Integer.MIN_VALUE && divisor ==-1)) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor ==1) return Integer.MIN_VALUE;
        if(divisor == 1) return dividend;
        if(divisor == -1) return -1*dividend;
        if(divisor == Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE) return -1;
            else return 0;
        }

        int r=0;
        int isNegtive = 1;
        if(dividend == Integer.MIN_VALUE){
            r++;
            if(divisor>0)
                dividend = Math.abs(dividend+divisor);
            else
                dividend = Math.abs(dividend-divisor);
        }

        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) isNegtive = -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while(dividend>=divisor){
            r++;
            dividend -= divisor;
        }

        return r*isNegtive;
    }


}
