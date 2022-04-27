package listnode;

import common.ListNode;

import java.util.List;

public class Demo25_2 {
    /**
     * 1->2->3->4->5->6
     * 2->1->4->3->6->5
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode a = head;
        ListNode b = head;

        for (int i = 0; i < k; i++) {
            if(b==null){
                return head;
            }
            b = b.next;
        }
        //反转前k个元素
        ListNode newHead = reverseKList(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    private ListNode reverseKList(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode curr = a;
        while (curr!=b){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }


}
