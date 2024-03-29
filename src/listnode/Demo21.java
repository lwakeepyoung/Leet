package listnode;

import common.ListNode;

public class Demo21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1!=null&&p2!=null){
            if(p1.val>p2.val){
                p.next = p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if(p1!=null){
            p.next=p1;
        }
        if(p2!=null){
            p.next=p2;
        }
        return pre.next;
    }
}
