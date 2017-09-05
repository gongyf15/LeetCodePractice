import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongyuanfeng on 2017/8/30.
 * 数组过界。边界条件没弄好
 */
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(i+1);

        for(int i=n-1;0<i;i--){
            int tmp = factorial(i);
            int r = Math.round((float)(k*1.0/tmp))-1;
            sb.append(list.get(r));
            list.remove(r);
            k = k-r*tmp;

        }
        sb.append(list.get(0));
        return sb.toString();
    }

    private int factorial(int n){
        if(n<=1) return 1;
        int r = 1;
        while(n!=1){
            r *= n;
            n--;
        }
        return r;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.print(s.getPermutation(3,2));
    }
}
