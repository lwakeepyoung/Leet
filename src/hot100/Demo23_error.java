package hot100;

import common.ListNode;

import java.util.List;

public class Demo23_error {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] listNodes,int left,int right){
        if(left==right){
            return listNodes[left];
        }
        int mid = left+(right-left)/2;
        ListNode l1 = merge(listNodes,left,mid);
        ListNode l2 = merge(listNodes,mid+1,right);
        return mergeTwoList(l1,l2);
    }

    public ListNode mergeTwoList(ListNode node1,ListNode node2){
        if(node1==null){
            return node2;
        }

        if(node2==null){
            return node1;
        }
        if(node1.val<node2.val){
            node1.next = mergeTwoList(node1.next,node2);
            return node1;
        }else {
            node2.next = mergeTwoList(node1,node2.next);
            return node2;
        }
    }
}
