/**
 * Created by gongyuanfeng on 2017/9/2.
 * 从后往前！
 * beat33.41%
 *
 * 这次写的比较简介
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for(int k=m+n+1; 0<=k ; k--){
            if(m==-1){
                nums1[k] = nums2[n--];
                continue;
            }
            if(n==-1)break;

            nums1[k] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }

    }
}
