package listnode;

import common.ListNode;
//链表题一定要画图看
public class Demo25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if(b==null){
                return null;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode curr = a;
        ListNode next = a;
        while (curr!=b){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
