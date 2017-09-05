/**
 * Created by gongyuanfeng on 2017/9/3.
 * 递归，超时
 */
public class Solution {
    public int numTrees(int n){
        if(n==0) return 0;
        return generateSubTrees(1,n);
    }

    private int generateSubTrees(int l, int r){
        if(l>r){return 1;}

        int trees =0;

        for(int i=l;i<=r;i++){
            int left = generateSubTrees(l,i-1);
           int right = generateSubTrees(i+1,r);
            trees += left*right;
        }
        return trees;
    }

}
