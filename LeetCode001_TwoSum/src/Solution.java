/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        //所有地方都必须有return!
        return result;

    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] num = {1,2,4,5};
        int[] r = s.twoSum(num,7);
        System.out.print(r[0]+","+r[1]);

    }
}