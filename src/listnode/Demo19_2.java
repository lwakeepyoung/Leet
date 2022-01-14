package listnode;

import common.ListNode;

public class Demo19_2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        //找出倒数第n+1个节点
        //next——》next.next
        ListNode p = findNthFromEnd(pre,n+1);
        p.next = p.next.next;
        return pre.next;
    }

    //找出倒数第n个节点
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
