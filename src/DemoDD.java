public class DemoDD {

    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val>list2.val){
            list2.next = merge(list1,list2.next);
            return list2;
        }else {
            list1.next = merge(list1.next,list2);
            return list1;
        }
    }
}
