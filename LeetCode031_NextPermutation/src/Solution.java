/**
 * Created by gongyuanfeng on 2017/8/23.
 */
import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int tmp = 0;
        if(len<1)return;

        for(int i=len-2;0<=i;i--){
            //不是完全倒序了
            if(nums[i]<nums[i+1]){
//        		if(i+1 == len-1){
//        			tmp = nums[len-1];
//            		nums[len-1] = nums[i];
//            		nums[i] = tmp;
//            		return;
//        		}
                //第i个值和后面比他大的最小值交换
                for(int j=len-1;i<j;j--){
                    if(nums[j]>nums[i]){
                        tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
                //i+1~len-1倒序
                for(int s=i+1,t=len-1;s<t;s++,t--){
                    tmp = nums[s];
                    nums[s] = nums[t];
                    nums[t] = tmp;
                }
                return;
            }
            else if(i==0){
                //0~len-1倒序
                for(int s=i,t=len-1;s<t;s++,t--){
                    tmp = nums[s];
                    nums[s] = nums[t];
                    nums[t] = tmp;
                }
                return;
            }
        }
    }


}
