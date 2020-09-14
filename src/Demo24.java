//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表
// 👍 601 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Demo24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        while ((head!=null)&& (head.next!=null)){
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode.next;
            firstNode.next = prevNode;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = secondNode;
        }
        return prevNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
