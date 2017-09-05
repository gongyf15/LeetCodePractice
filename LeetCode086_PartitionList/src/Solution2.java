/**
 * Created by gongyuanfeng on 2017/9/2.
 * beat 2.29%
 */
public class Solution2 {
    public ListNode partition(ListNode head, int x) {

        ListNode LessHead = new ListNode(0);
        ListNode NoLessHead = new ListNode(0);
        ListNode p = LessHead, q = NoLessHead;

        while(head!=null){
            if(head.val < x){p.next = head; p =p.next;}
            else {q.next = head; q= q.next;}

            head = head.next;
        }

        q.next = null;
        p.next = NoLessHead.next;
        return LessHead.next;
    }
}
