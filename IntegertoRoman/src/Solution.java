/**
 * Created by gongyuanfeng on 2017/7/21.
 * 最简单方法，直接枚举出，0～9，0十到9十，0百～9百，0千到3千的样式
 */
public class Solution {
    public String intToRoman(int num) {
        if(num<1 && num> 4000)return "";

        String[] c = new String[]{"M","D","C","L","X","V","I"};
        String result = "";
        for(int i=0;i<num/1000;i++)
            result += c[0];
        num %= 1000;

        //x几位
        int y = num;
        int len = 0;
        while(y != 0){
            len++;
            y /= 10;
        }
        //百位起逐位下降
        for(int i=len-1;0<=i;i--){
            int j=2-i;
            int tmp = (int) (num/Math.pow(10, i));
            if(tmp==9){
                result+=c[2*j+2];
                result+=c[2*j];
            }
            else if(tmp >= 5){
                result+=c[2*j+1];
                for(int s=0;s<tmp-5;s++)
                    result+=c[2*j+2];
            }
            else if(tmp == 4){
                result+=c[2*j+2];
                result+=c[2*j+1];
            }
            else{
                for(int s=0;s<tmp;s++)
                    result+=c[2*j+2];
            }

            num = (int) (num%Math.pow(10, i));
        }

        return result;

    }

}
