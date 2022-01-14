package listnode;

import common.ListNode;

public class Demo83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null){
            if(slow.val!= fast.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next=null;
        return slow;
    }
}
