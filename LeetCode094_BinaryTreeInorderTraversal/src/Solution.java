import java.util.*;

/**
 * Created by gongyuanfeng on 2017/9/3.
 * beat 28.53%
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        if(root == null)return r;

        s.push(root);
        while(!s.empty()){
            root = s.pop();
            if(root.left==null && root.right==null){r.add(root.val); continue;}
            if(root.right!=null) s.push(root.right);
            s.push(new TreeNode(root.val));
            if(root.left!=null) s.push(root.left);
        }

        return r;
    }
}
