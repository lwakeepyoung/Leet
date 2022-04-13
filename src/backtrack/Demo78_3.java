package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo78_3 {

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(list,nums,0);
        return result;
    }

    public void backTrack(LinkedList<Integer> list, int[] nums, int start){
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backTrack(list,nums,i+1);
            list.removeLast();
        }
    }
}
