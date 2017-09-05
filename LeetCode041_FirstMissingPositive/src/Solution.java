/**
 * Created by gongyuanfeng on 2017/8/28.
 * 把对应的数转移到对应的位置上
 * beta 57.83%
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)return 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1 && nums[i]>0 && nums[i]<=nums.length){
                if(swap(nums,i,nums[i]-1))
                    i--;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1)
                return i+1;
        }

        return nums.length+1;
    }

    private boolean swap(int[] nums, int l, int r){
        if(nums[l]==nums[r]) return false;

        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;

        return true;
    }
}
