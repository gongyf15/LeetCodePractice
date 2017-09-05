/**
 * Created by gongyuanfeng on 2017/9/2.
 * beat 5%,可以不用生成新的节点
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)return head;

        ListNode LessHead = new ListNode(0);
        ListNode NoLessHead = new ListNode(0);
        ListNode p = LessHead, q = NoLessHead;
        if(head.val < x){p.next = new ListNode(head.val); p =p.next;}
        else {q.next = new ListNode(head.val); q= q.next;}

        while(head.next!=null){
            head = head.next;
            if(head.val < x){p.next = new ListNode(head.val); p =p.next;}
            else {q.next = new ListNode(head.val); q= q.next;}
        }

        p.next = NoLessHead.next;
        return LessHead.next;
    }
}
