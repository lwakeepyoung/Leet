package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: lwa
 * @Date: 2022/1/3 16:45
 */
public class Demo15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nTargetSum(nums,3,0,0);
    }

    private List<List<Integer>> nTargetSum(int[] nums, int n,int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(n<0 || length < n){
            return result;
        }else if(n==2){
            int lo = start;
            int hi = length-1;
            while (lo<hi){
                int sum = nums[lo] + nums[hi];
                int left = nums[lo];
                int right = nums[hi];
                if(sum < target){
                    //lo++
                    //优化 如果重复直接跳过
                    while (lo<hi && nums[lo] == left){
                        lo++;
                    }
                }else if(sum > target){
                    // hi--
                    //优化 如果重复直接跳过
                    while (lo<hi && nums[hi] == right){
                        hi--;
                    }
                }else {
                    List<Integer> list = Stream.of(nums[lo],nums[hi]).collect(Collectors.toList());;
                    result.add(list);
                    //如果是重复的数字直接跳过
                    while (lo<hi && nums[lo] == left){
                        lo++;
                    }
                    while (lo<hi && nums[hi] == right){
                        hi--;
                    }
                }
            }
        }else {
            for (int i = start; i < length; i++) {
                List<List<Integer>> sub = nTargetSum(nums,n-1,i+1,target-nums[i]);
                for(List<Integer> list: sub){
                    list.add(nums[i]);
                    result.add(list);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }

        }
        return result;
    }
}
