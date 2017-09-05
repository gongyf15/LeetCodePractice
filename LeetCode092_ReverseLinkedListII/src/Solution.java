/**
 * Created by gongyuanfeng on 2017/9/3.
 * beat 24.68%
 * 写得不够好，应该是一个个插入，而不是创建一个新链，最后合并
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p =head;
        ListNode q = new ListNode(Integer.MIN_VALUE);
        q.next = head;

        ListNode t,tail = null;
        ListNode preHead = new ListNode(0);

        int count = 1;
        while(p!=null){
            if(count==m) tail =p;
            if(m<=count && count<=n){

                t = p;

                q.next = p.next;
                p = q.next;

                t.next = preHead.next;
                preHead.next = t;

            }
            else{
                q = p;
                p = p.next;
            }
            if(count==n){
                q.next = preHead.next;
                tail.next = p;

                return q.val==Integer.MIN_VALUE?q.next:head;
            }

            count ++;

        }

        return head;
    }
}
