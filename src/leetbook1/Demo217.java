package leetbook1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo217 {
//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet();
//        for (int i = 0; i < nums.length; i++) {
//            if(!set.add(nums[i])){
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count()<nums.length;
    }
}
