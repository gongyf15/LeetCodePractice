import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gongyuanfeng on 2017/8/29.
 * beat 26%
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        traceback(result,new ArrayList<>(),new int[nums.length], nums);

        return result;
    }

    private void traceback(List<List<Integer>> result ,List<Integer> list ,int[] set, int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if( set[i]==1 ) continue;
            //set[i-1]==0需要仔细理解
            if( (0<i&&nums[i]==nums[i-1]) && set[i-1]==0 )continue;

            list.add(nums[i]);
            set[i] = 1;
            traceback(result, list, set, nums);
            list.remove(list.size()-1);
            set[i] = 0;

        }
        return;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] a= new int[]{1,1,2};
        List<List<Integer>> result = s.permuteUnique(a);

        for(int i=0;i<result.size();i++){
            List<Integer> l = result.get(i);
            for(int j=0;j< l.size();j++){
                System.out.print(l.get(j)+",");
            }
            System.out.println("end");
        }
    }

}
