package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo15_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3){
            return result;
        }else {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                //从小到大排序，如果前面数>0，永远不能为0
                if(nums[i]>0){
                    return result;
                }
                //排除重复数字
                if(i>0 && nums[i]==nums[i-1]){
                    continue;
                }

                int l = i+1;
                int r = nums.length-1;
                while (l<r){
                    int sum = nums[i]+nums[l]+nums[r];
                    if(sum>0){
                        r--;
                    }
                    if(sum<0){
                        l++;
                    }
                    if(sum==0){
                        //addresult
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        while (l<r && nums[l] == nums[l+1]){
                            l++;
                        }
                        while (l<r && nums[r] == nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
