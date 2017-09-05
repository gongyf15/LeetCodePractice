/**
 * Created by gongyuanfeng on 2017/8/23.
 *
 * 长的超时
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[2];
        result[0] = l;
        result[1] = r;
        while(l < r){
            if( nums[(l+r)/2] > target ){
                //防止在一个地方无法前进
                r = (l+r)/2<r?(l+r)/2:r-1;
            }
            else if(nums[(l+r)/2] < target){
                l = (l+r)/2>l?(l+r)/2:l+1;
            }
        }
        if(nums[l] == target){
            result[0] = l;
            result[1] = l;
            //向前搜索
            for(int i=l-1; -1 < i; i--){
                result[0] = i;
                if( nums[i] != target ){
                    result[0] = i+1;
                    break;
                }
            }
            //向后搜索
            for(int i=l+1;  i < nums.length; i++){
                result[1] = i;
                if( nums[i] != target ){
                    result[1] = i-1;
                    break;
                }
            }
        }
        else{
            result[0] = -1;
            result[1] = -1;
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = new int[]{1,4};
        int[] r = s.searchRange(nums,4);
        System.out.println(r[0]+","+r[1]);
    }
}
