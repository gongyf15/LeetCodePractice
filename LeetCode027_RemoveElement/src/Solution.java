/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        for(int i=len-1;-1<i;i--){
            if(nums[i]==val){
                len--;
                nums[i]=nums[len];
            }
        }
        return len;
    }

}
