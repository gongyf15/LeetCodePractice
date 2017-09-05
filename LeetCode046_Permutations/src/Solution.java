import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by gongyuanfeng on 2017/8/29.
 * beat 7.04%
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        traceback(result,new ArrayList<>(),new HashSet<>(),nums);

        return result;
    }

    private void traceback(List<List<Integer>> result ,List<Integer> list ,HashSet<Integer> set,int[] nums){
        if(set.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) continue;

            list.add(nums[i]);
            set.add(nums[i]);
            traceback(result,list,set,nums);
            list.remove(list.size()-1);
            set.remove(nums[i]);
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] a= new int[]{1,2};
        s.permute(a);
    }

}
