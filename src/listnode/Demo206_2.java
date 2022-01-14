package listnode;

import common.ListNode;

public class Demo206_2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre =curr;
            curr = temp;
        }
        return pre;
    }
}
