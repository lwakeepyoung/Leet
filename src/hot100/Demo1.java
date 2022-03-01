package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lwa
 * @Date: 2022/2/28 19:10
 */
public class Demo1 {

    private Map<Integer,Integer> indexMap;

    public int[] twoSum(int[] nums, int target) {
        indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if(indexMap.containsKey(value)){
                return new int[]{indexMap.get(value),i};
            }else {
                indexMap.put(target-value,i);
            }
        }
        return new int[]{};
    }
}
