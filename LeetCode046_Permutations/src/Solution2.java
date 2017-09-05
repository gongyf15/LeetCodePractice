import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongyuanfeng on 2017/8/29.
 * beat 27.5%,不用HashSet明显快了
 */
public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        traceback(result,new ArrayList<>(),new int[nums.length],nums);

        return result;
    }

    private void traceback(List<List<Integer>> result ,List<Integer> list ,int[] set,int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(set[i]==1) continue;

            list.add(nums[i]);
            set[i]=1;
            traceback(result,list,set,nums);
            list.remove(list.size()-1);
            set[i]=0;
        }
    }

    public static void main(String[] args){
        Solution2 s = new Solution2();
        int[] a= new int[]{1,2};
        s.permute(a);
    }

}
