package listnode;

import common.ListNode;

/**
 * @Author: lwa
 * @Date: 2022/1/8 17:26
 */
public class Demo24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre= curr;
            curr = temp;
        }
        return head;
    }
}
