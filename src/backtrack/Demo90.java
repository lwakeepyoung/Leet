package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo90 {

    private List<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return result;
    }

    private void backtrack(int[] nums, int start) {

        result.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums,i+1);
            track.removeLast();
        }
    }
}
