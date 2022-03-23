package hot100;

import common.ListNode;

import java.util.List;

/**
 * @Author: lwa
 * @Date: 2022/3/22 21:25
 */
public class Demo19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        //删除节点
        return p.next;
    }

}
