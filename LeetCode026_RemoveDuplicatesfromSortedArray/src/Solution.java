/**
 * Created by gongyuanfeng on 2017/7/21.
 */
import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null)return 0;

        int t=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[t] = nums[i+1];
                t++;
            }
        }
        return t;
    }



}

