/**
 * Created by gongyuanfeng on 2017/7/21.
 * 回溯递归最好
 */
import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        //简单的
        HashSet<String> set = this.generateSimpleParenthesis(n);

        List<String> str = new ArrayList<String>();
        str.addAll(set);
        return str;

    }

    public HashSet<String> generateSimpleParenthesis(int n){
        HashSet<String> set = new HashSet<String>();
        if(n==1){
            set.add("()");
            return set;
        }

        HashSet<String> setNew = new HashSet<String>();
        for(int i=1; i<=n/2; i++){
            HashSet<String> set1 = this.generateSimpleParenthesis(i);
            HashSet<String> set2 = this.generateSimpleParenthesis(n-i);
            for(String s1:set1){
                for(String s2:set2){
                    setNew.add(s1+s2);
                    setNew.add(s2+s1);
                }
            }
        }

        set = this.generateSimpleParenthesis(n - 1);
        for (String s : set) {
            setNew.add("(" + s + ")");
        }

        return setNew;
    }

}
