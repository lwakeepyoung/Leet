package listnode;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo206 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr!=null){
//            ListNode temp = curr.next;
//            curr.next = pre;
//            pre =curr;
//            curr = temp;
//        }
//        return pre;
//    }
}
