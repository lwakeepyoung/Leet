package listnode;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个单向链表 奇数节点升序 偶数节点降序 排序
 */
public class DemoDD {

    public ListNode solution(ListNode listNode){
        ListNode[] divideList = divideListNode(listNode);
        ListNode listNode2 = reverseListNode(divideList[1]);
        ListNode resultNode = merge(divideList[0],listNode2);
        return resultNode;
    }

    public ListNode[] divideListNode(ListNode listNode){
        ListNode pre1 = new ListNode(-1);
        ListNode pre2 = new ListNode(-1);
        ListNode p1 = pre1;
        ListNode p2 = pre2;
        ListNode p = listNode;
        //计数
        int cur = 1;
        while (p!=null){
            if(cur%2==1){
                p1.next = p;
                p1 = p1.next;
            }else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
            cur++;
        }
        p1.next = null;
        p2.next = null;
        return new ListNode[]{pre1.next,pre2.next};
    }

    public ListNode reverseListNode(ListNode listNode){
        if(listNode==null || listNode.next ==null){
            return listNode;
        }
        ListNode pre = null;
        ListNode curr = listNode;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1!=null && p2!=null){
            if(p1.val>p2.val){
                p.next = p2;
                p2=p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if(p1!=null){
            p.next  = p1;
        }
        if(p2!=null){
            p.next = p2;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        //ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        //listNode4.next = listNode5;
        new DemoDD().solution(listNode1);

    }
}
