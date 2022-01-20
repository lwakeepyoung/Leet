package listnode;

import common.ListNode;

/**
 * @Author: lwa
 * @Date: 2022/1/9 21:13
 */
public class Demo24_2 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next=head;
        head.next= null;
        return newNode;
    }
}
