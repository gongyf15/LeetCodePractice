/**
 * Created by gongyuanfeng on 2017/8/28.
 * beat 9.11%
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        return water(height, 0, height.length-1);
    }

    private int water(int[] height, int l, int r){
        if(r-l<2) return  0;

        int max = -2,sec_max = -1;
        int max_id = -1, sec_max_id =-1;
        for(int i=l;i<=r;i++){
            if(height[i]>max){
                sec_max = max;
                sec_max_id = max_id;
                max = height[i];
                max_id = i;
            }
            else if(height[i]>sec_max){
                sec_max = height[i];
                sec_max_id = i;
            }
        }

        int l_t = Math.min(max_id,sec_max_id);
        int r_t = Math.max(max_id,sec_max_id);
        int top = Math.min(max,sec_max);
        int sum = 0;
        for(int i=l_t+1;i<r_t;i++) {
            sum += top - height[i];
        }

        return water(height,l,l_t) +
               water(height,r_t,r) + sum;

    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] h = new int[]{4,2,0,3,2,5};
        System.out.print(s.trap(h));
    }
}
