import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongyuanfeng on 2017/9/3.
 * beat 89.27%
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        char[] c = s.toCharArray();

        List<String> r = new ArrayList<>();
        String[] ip = new String[4];
        backtracing(r,ip,c,0,0);

        return r;
    }

    private void backtracing(List<String> r, String[] ip, char[] c, int start, int n ){
        if(n == 4){
            if(start == c.length) r.add(ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3]);
            return;
        }

        for(int i=start;i<c.length;i++){
            String stmp = isValid(c,start,i);
            if(!stmp.equals("")){
                ip[n] = stmp;
                backtracing(r,ip,c,i+1,n+1);
            }
            else break;
        }

    }

    private String isValid(char[] c, int start,int end){
        if( (c[start]=='0' && end > start) || end-start > 2 ) return "";

        int n = 0;
        for(int i=start;i<=end;i++)
            n = 10*n+(c[i]-'0');

        return n<=255?n+"":"";
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<String> r = s.restoreIpAddresses("0000");
        for(int i=0;i<r.size();i++) System.out.print(r.get(i)+",");
    }
}
