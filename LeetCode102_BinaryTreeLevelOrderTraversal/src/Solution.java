import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by gongyuanfeng on 2017/9/4.
 * 层次遍历，用队列
 * beat8.6%,可以改进为1个Queue,二重循环
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if(root==null)return r;

        List<Integer> rlvl= new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        int lvl = 1;
        queue.add(root);
        level.add(lvl);

        while (!queue.isEmpty()){
            TreeNode head = queue.poll();
            int lnum = level.poll();

            if(lnum==lvl+1){
                r.add(rlvl);
                rlvl= new ArrayList<>();
                lvl = lnum;
            }

            rlvl.add(head.val);
            if(head.left!=null){
                queue.add(head.left);
                level.add(lnum+1);
            }
            if(head.right!=null){
                queue.add(head.right);
                level.add(lnum+1);
            }
        }
        r.add(rlvl);

        return r;
    }


}
