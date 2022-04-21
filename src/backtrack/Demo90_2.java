package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo90_2 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> tracks = new LinkedList<>();
        Arrays.sort(nums);
        backTrack(tracks,nums,0);
        return result;
    }

    public void backTrack(LinkedList<Integer> tracks,int[] nums,int start){
        result.add(new ArrayList<>(tracks));

        for (int i = start; i < nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            tracks.add(nums[i]);
            backTrack(tracks,nums,i+1);
            tracks.removeLast();
        }
    }
}
