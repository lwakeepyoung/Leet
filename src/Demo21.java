//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1237 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Demo21 {
    /**
     * 1.两个合并后重新排序
     * 2.if l1.next>l2 l1.next = l2,l2.next = null;
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1!=null && l2!=null){
            if(l1.val< l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2= l2.next;
            }
            pre = pre.next;
        }
        //合并到l1或l2上，需要判断
        pre.next = l1==null?l2:l1;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode head = new ListNode(1,l2);

        ListNode l5 = new ListNode(4);
        ListNode l4 = new ListNode(3,l5);
        ListNode head2 = new ListNode(1,l4);
        new Demo21().mergeTwoLists(head,head2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
