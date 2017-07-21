/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        if(head == null) return head;
        else if(head.next == null ) return head;

        int count=1;
        ListNode p = head;
        ListNode mark = null;
        ListNode tail = null;
        ListNode q = null;
        boolean flag = false;
        while(p.next != null){
            p = p.next;
            count++;
            if(count == k){
                count = 1;
                q = p.next;
                p.next = null;

                ListNode[] reverse = this.reverseNode(head);
                if(!flag){
                    flag = !flag;
                    mark = reverse[0];
                    tail = reverse[1];
                    reverse[1].next = q;
                    head = q;
                    p = q;
                }
                else{
                    tail.next = reverse[0];
                    tail = reverse[1];
                    reverse[1].next = q;
                    head = q;
                    p = q;
                }
            }
            if(p == null)
                break;
        }
        if(!flag) return head;
        return mark;
    }

    private ListNode[] reverseNode(ListNode head) {
        ListNode tail = head;
        ListNode q = head;
        ListNode p = head.next;
        while(p.next != null){
            head = p;
            p = p.next;
            head.next = q;
            q=head;
        }
        head = p;
        p.next = q;

        return new ListNode[]{head,tail};
    }


}

