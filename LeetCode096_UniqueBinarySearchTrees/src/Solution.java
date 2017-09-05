import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongyuanfeng on 2017/9/3.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return generateSubTrees(1,n);
    }

    private List<TreeNode> generateSubTrees(int l, int r){
        List<TreeNode> trees = new ArrayList<>();
        if(l>r){trees.add(null); return trees;}

        for(int i=l;i<=r;i++){
            List<TreeNode> left = generateSubTrees(l,i-1);
            List<TreeNode> right = generateSubTrees(i+1,r);
            for(TreeNode lsub:left){
                for(TreeNode rsub:right){
                    TreeNode root = new TreeNode(i);
                    root.left = lsub;
                    root.right = rsub;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
