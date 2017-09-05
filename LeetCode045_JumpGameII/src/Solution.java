/**
 * Created by gongyuanfeng on 2017/8/29.
 * 超时,因为后面会重复计算很多次
 */
public class Solution {
    public int jump(int[] nums) {
        if(nums[0]==0&&nums.length==1)return 0;
        return work(nums, 0);
    }

    private int work(int[] nums, int l){
        //只能跳0步
        if(nums[l]==0) return 9999;
        //已经在最后面
        if(l==nums.length-1) return 0;
        //可以一步到最后
        if(nums.length-1-l<=nums[l]) return 1;

        int min_step = Integer.MAX_VALUE;
        //i代表跳几格
        for(int i=1;i<=nums[l]&&(l+i)<nums.length;i++){
            int step = work(nums,l+i) + 1;
            if(step<min_step){
                min_step = step;
            }

        }
        return min_step;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] a= new int[]{1,2,1,1,1};
        System.out.println(s.jump(a));
    }
}
