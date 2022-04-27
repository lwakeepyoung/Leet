package listnode;

import common.ListNode;

import java.util.List;

public class Demo23_2 {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        return merge(lists,0, lists.length-1);
    }

    public ListNode merge(ListNode[] listNodes,int l,int r){
        if (l == r) return listNodes[l];
        int mid = l+(r-l)/2;
        ListNode listNode1 = merge(listNodes,l,mid);
        ListNode listNode2 = merge(listNodes,mid+1,r);
        return mergeTwoList(listNode1,listNode2);
    }


    public ListNode mergeTwoList(ListNode listNode1,ListNode listNode2){
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        ListNode p1 = listNode1;
        ListNode p2 = listNode2;
        while (p1!=null && p2!=null){
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
            p.next = p1;
        }
        if(p2!=null){
            p.next = p2;
        }
        return pre.next;
    }
}
