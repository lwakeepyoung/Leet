package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo15 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                return result;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum<0){
                    l++;
                }
                if(sum>0){
                    r--;
                }
                if(sum==0){
                    addList(nums[i],nums[l],nums[r]);
                    //去重复
                    while (l<r && nums[l]==nums[l+1]){
                        l++;
                    }
                    while (l<r && nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return result;
    }

    private void addList(int first, int second, int three) {
        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(three);
        result.add(list);
    }


}
