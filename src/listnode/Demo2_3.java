package listnode;

import common.ListNode;

public class Demo2_3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(-1);
        ListNode p = preNode;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1!=null || p2!=null || carry>0){
            int value = carry;
            if(p1!=null){
                value += p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                value += p2.val;
                p2 = p2.next;
            }
            carry = value/10;
            value = value%10;
            p.next = new ListNode(value);
            p = p.next;
        }
        return preNode.next;
    }
}
