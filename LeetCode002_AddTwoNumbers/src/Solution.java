/**
 * Created by gongyuanfeng on 2017/7/21.
 * 如果位数不一，可以看作高位是0
 */
import java.util.Arrays;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp,tmp2;
        ListNode p = l1;//new ListNode(l1.val);
        ListNode q = l2;//new ListNode(l2.val);
//        p.next=null;
//        q.next=null;
//        int np=1,nq=1;
//        //正转过来
//        while(l1.next!=null){
//        	l1 = l1.next;
//        	tmp = new ListNode(l1.val);
//        	tmp.next = p;
//        	p = tmp;
//        	np++;
//        }
//        while(l2.next!=null){
//        	l2 = l2.next;
//        	tmp = new ListNode(l2.val);
//        	tmp.next = q;
//        	q = tmp;
//        	nq++;
//        }
        //保证p长
//        if(nq>np){
//        	tmp = p;
//        	p = q;
//        	q = tmp;
//
//        	int ntmp = np;
//        	np = nq;
//        	nq = ntmp;
//        }
        //正序相加存为逆序
        //进位
        ListNode result = new ListNode((p.val+q.val)%10);
        int carry = (p.val+q.val)/10;
        result.next=null;
        tmp=result;
        while(q.next!=null && p.next!=null){
            p=p.next;
            q=q.next;
            tmp2 = new ListNode((p.val+q.val+carry)%10);
            carry = (p.val+q.val+carry)/10;
            tmp.next=tmp2;
            tmp=tmp2;
        }
        if(p.next==null){
            p=q;
        }
        while(p.next!=null){
            p=p.next;
            tmp2 = new ListNode((p.val+carry)%10);
            carry = (p.val+carry)/10;
            tmp.next=tmp2;
            tmp=tmp2;
        }
        if(carry==1){
            tmp.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String[] args){

    }

}