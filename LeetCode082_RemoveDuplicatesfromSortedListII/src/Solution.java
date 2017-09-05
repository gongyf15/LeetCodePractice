import java.util.Locale;

/**
 * Created by gongyuanfeng on 2017/9/1.
 * beat 13.9%
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t=head, p = head, q = p;
        boolean isHead = true;
        if(p==null)return head;

        int count = 1;

        while(q.next != null){
            q = q.next;
            if(q.val == p.val){
                count ++;
                continue;
            }
            else {
                if(count>1){
                    p = q;
                    if(isHead) {
                        head = q;
                        t = q;
                    }
                    else t.next = q;

                }
                else{
                    t= isHead?t:p;
                    p=q;
                    isHead = false;
                }
            }
            count = 1;
        }

        if(count>1){
            if(isHead) head = null;
            else t.next = null;
        }

        return head;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = new int[]{-3,-3,-2,-1,-1,0,0,0,0,0};
        ListNode head = new ListNode(nums[0]);
        ListNode p =head;
        for(int i=1;i<nums.length;i++){
            p.next = new ListNode(nums[i]);
            p = p.next;
        }

        p = s.deleteDuplicates(head);

        if(p!=null) {
            while (p.next != null) {
                System.out.print(p.val + ",");
                p = p.next;
            }
            System.out.print(p.val);
        }
    }
}
