/**
 * Created by gongyuanfeng on 2017/9/1.
 * 没跑通
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length<1)return false;
        int up;
        if( nums.length < 1 || nums[0] == target )return true;
        if( nums[0] > target ) up = -1;
        else up = 1;

        int l=0, r =nums.length-1;
        while(l<r){
            int middle = (l+r)/2;
            if( up*( nums[0]- nums[middle]) > 0 ){
                if( up >0 )r=middle==r?middle-1:middle;
                else l=middle==l?middle+1:middle;
            }

            if(nums[middle]==target)return true;
            else if(nums[middle]>target)r=middle==r?middle-1:middle;
            else l=middle==l?middle+1:middle;
        }

        return nums[l]==target;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.search(new int[]{1,1,3},3));
    }
}
