/**
 * Created by gongyuanfeng on 2017/8/29.
 * 从后往前，利用后面到信息
 * 依然超时
 */
public class Solution2 {
    public int jump(int[] nums) {
        int[] step = new int[nums.length];
        step[nums.length-1]=0;
        for(int i=nums.length-2;0<=i;i--){
            if(nums[i]==0) {step[i]=Integer.MAX_VALUE/2; continue;}

            int min = Integer.MAX_VALUE;
            //这部分很耗时，尤其档nums[i]很大
            for(int s=1;s<=nums[i]&&(i+s)<nums.length;s++){
                if(step[i+s]<min) min = step[i+s];
            }
            step[i] = min + 1;
        }
        return step[0];
    }

    public static void main(String[] args){
        Solution2 s = new Solution2();
        int[] a= new int[]{1,2};
        System.out.println(s.jump(a));
    }
}
