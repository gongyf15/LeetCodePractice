import java.util.Arrays;

/**
 * Created by gongyuanfeng on 2017/7/21.
 * 不能暴力求，装多少水取决于短的，只有短的变长了（向内移）才可能增加装水量
 */
public class Solution {

    public int maxArea(int[] height) {
        int[] result= new int[(height.length-1)*height.length/2];
        int t=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                result[t] = (j-i)*Math.min(height[i],height[j]);
                t++;
            }
        }
        Arrays.sort(result);
        return result[t-1];
    }


}
