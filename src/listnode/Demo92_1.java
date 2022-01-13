package listnode;

import common.ListNode;

public class Demo92_1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode p = dummyNode.next;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
            p = p.next;
        }
        //将p的下一个节点放到pre下个节点上
        for (int i = 0; i < right-left; i++) {
            ListNode removeNode = p.next;
            p.next = p.next.next;

            removeNode.next = pre.next;
            pre.next = removeNode;
        }
        return dummyNode.next;
    }
}
