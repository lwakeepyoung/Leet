package listnode;

import common.ListNode;

public class Demo21_4 {
    public ListNode mergeListNodes(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val>list2.val){
            list2.next = mergeListNodes(list1,list2.next);
            return list2;
        }else {
            list1.next = mergeListNodes(list1.next,list2);
            return list1;
        }
    }

}
