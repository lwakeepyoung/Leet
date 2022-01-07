package listnode;

import common.ListNode;

public class Demo19_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        //删除节点要找到前一个节点
        ListNode x = findKthFromEnd(pre, n + 1);
        x.next = x.next.next;
        return pre.next;
    }

    public ListNode findKthFromEnd(ListNode head, int k){
        ListNode p1 = head;
        //p1 移动k步
        for (int i = 0; i < k; i++) {
            p1 =  p1.next;
        }
        ListNode p2 = head;
        //p1.next==null时 p2移动的时length-k步
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
