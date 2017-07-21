import java.util.Arrays;

/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {
    //结果21/125，时间过不去
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minValue = Integer.MAX_VALUE;
        int result = 0;
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            if(i>0 && nums[i-1]==nums[i])continue;
            //two sum
            int l=i+1,r=len-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int sub = sum-target;
                if(Math.abs(sub)<minValue){
                    minValue = Math.abs(sub);
                    result = target+sub;
                }
//        		while(l<r && nums[l+1]==nums[l]) l++;
//        		while(l<r && nums[r-1]==nums[r]) r++;
                if(sub>0) r--;
                else l++;
            }

        }
        return result;
    }


}
