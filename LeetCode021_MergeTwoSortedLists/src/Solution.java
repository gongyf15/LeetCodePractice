/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode t1 = l2;
        ListNode head = l2;

        while (l2 != null) {
            if (l2.val > l1.val && l2 != t1) {
                ListNode tmp = new ListNode(l1.val);
                tmp.next = l2;
                t1.next = tmp;
                t1 = tmp;

                if(l1.next != null)
                    l1=l1.next;
                else
                    return head;

                continue;
            }

            t1 = l2;
            l2=l2.next;

        }

        if(l2 == null)
            t1.next = l1;

        return head;

    }


}

/*
 * 思路：由于都是排好序的，所以只需要把一个链的每个点分别插到另个链，
 * 且不需要从头开始搜索
 */