package listnode;

import common.ListNode;

import java.util.List;

public class Demo24_4 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
