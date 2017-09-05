/**
 * Created by gongyuanfeng on 2017/9/5.
 * beat 22.32%
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode p = root;
        while(p!=null){
            if(p.left!=null){
                TreeNode t = p.right;
                p.right = p.left;
                p.left = null;
                TreeNode q =p;

                //找到最右点
                while (q.right!=null) q=q.right;

                q.right = t;
            }
            p = p.right;
        }
    }
}
