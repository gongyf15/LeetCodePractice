/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {
    public int reverse(int x) throws NumberFormatException{
        String str = String.valueOf(Math.abs(x));
        StringBuffer sb = new StringBuffer(str);
        str = sb.reverse().toString();
        int result = 0;
        try{
            result = Integer.valueOf(str);
        }
        catch(NumberFormatException e){
            return 0;
        }
        if(x<0)
            result = -1*result;

        return result;
    }

}
