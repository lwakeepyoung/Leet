package listnode;

import common.ListNode;

import java.util.List;

public class Demo_offer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k-->0){
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
