/**
 * Created by gongyuanfeng on 2017/9/4.
 * beat 67.43%
 */
public class Solution {
    //善用类成员变量
    TreeNode p=null;
    TreeNode q=null;
    TreeNode pre=null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        if(p!=null&&q!=null) {
            int tmp = p.val;
            p.val = q.val;
            q.val = tmp;
        }
    }

    private void inorder(TreeNode root){
        if(root.left != null) inorder(root.left);
        if(pre!=null && pre.val>root.val){ //出现逆序
            if(p==null&&q==null){
                p = pre;
                q = root;
            }
            else {
                q = root;
            }
        }
        pre = root;
        if(root.right != null) inorder(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);

        Solution s = new Solution();
        s.recoverTree(root);
    }
}
