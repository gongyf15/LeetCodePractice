/**
 * Created by gongyuanfeng on 2017/7/21.
 * 改了node的值，不符合规定
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        else if (head.next == null)
            return head;

        int tmp = 0;
        ListNode mark = head;
        while (true) {
            tmp = head.val;
            head.val = head.next.val;
            head.next.val = tmp;

            head = head.next.next;
            if (head == null)
                return mark;
            else if (head.next == null)
                return mark;
        }

    }

}
