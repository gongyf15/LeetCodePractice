/**
 * Created by gongyuanfeng on 2017/8/28.
 * beat 16.8%
 * StringBuilder可以用append等，快
 */
public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        String s;
        for(int i=1;i<n;i++){
            s = "";
            char count ='0';
            char num = str.charAt(0);
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)==num)count++;
                else{
                    s+=count+""+num;
                    num = str.charAt(j);
                    count ='1';
                }
            }
            s += count+""+num;
            str = s;
        }
        return str;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println( s.countAndSay(4) );
    }
}
