import java.util.*;

/**
 * Created by gongyuanfeng on 2017/8/28.
 * beat 47.35%
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> r = new ArrayList<>();
        List<Integer> t =new ArrayList<>();
        backtrack(r, t, new HashSet<String>(),candidates, 0,0,target);

        return r;
    }

    private void backtrack(List<List<Integer>> r, List<Integer> t,Set<String> s,int[] candidates, int start , int sum, int target){

        for(int i=start;i<candidates.length;i++){
            if(sum+candidates[i] == target){
                t.add(candidates[i]);
                //去重
                StringBuilder sb = new StringBuilder();
                for(int ii=0;ii<t.size();ii++)
                    sb.append(t.get(ii));
                String str = sb.toString();

                if(!s.contains(str)) {
                    r.add(new ArrayList<>(t));
                    s.add(str);
                }
                t.remove(t.size()-1);
                return;
            }
            else if(sum+candidates[i] > target) return;
            else {
                t.add(candidates[i]);
                backtrack(r, t, s,candidates, i+1, sum+candidates[i],target);
                t.remove(t.size()-1);
                continue;

            }
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] c = new int[]{1,1,2,5,6,7,10};

        List<List<Integer>> r= s.combinationSum2(c,8);
        for(int i=0;i<r.size();i++){
            List<Integer> t = r.get(i);
            for(int j=0;j<t.size();j++){
                System.out.print(t.get(j)+",");
            }
            System.out.println("end");
        }
    }
}
