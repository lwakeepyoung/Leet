package leetbook1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lwa
 * @Date: 2021/12/4 13:45
 */
public class Demo350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums2.length;i++){
            int key = nums2[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(int i=0;i<nums1.length;i++){
            int key = nums1[i];
            if(map.containsKey(key)){
                int count = map.get(key);
                if(count==0){
                    map.remove(key);
                }else{
                    list.add(key);
                    map.put(key,--count);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
