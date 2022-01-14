package listnode;

import common.ListNode;

public class Demo92_2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode p = dummyNode.next;
        //移动到要反转到前一个位置
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
            p = p.next;
        }
        for (int i = 0; i < right-left; i++) {
            //删除p后面到节点插入pre后面
            ListNode removeNode = p.next;
            p.next = p.next.next;

            //加到pre后面
            removeNode.next = pre.next;
            pre.next = removeNode;
        }
        return dummyNode.next;
    }
}
