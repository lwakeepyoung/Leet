package listnode;

import common.ListNode;

import java.util.List;

public class Demo19_3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode x = findNthFromEnd(pre,n+1);
        x.next = x.next.next;
        return pre.next;
    }

    public ListNode findNthFromEnd(ListNode head,int n){
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
