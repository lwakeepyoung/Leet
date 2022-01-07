package listnode;

import common.ListNode;

public class Demo19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode x = findNthFromEnd(pre,n+1);
        x.next = x.next.next;
        return pre.next;
    }

    public ListNode findNthFromEnd(ListNode head,int k){
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
