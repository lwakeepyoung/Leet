package leetbook1;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if(map.get(val)!=null&& i!=map.get(val)){
                return new int[]{i,map.get(val)};
            }else {
                map.put(target-val,i);
            }
        }
        return new int[]{};
    }
}
