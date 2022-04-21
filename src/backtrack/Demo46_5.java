package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo46_5 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> tracks = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums);
        return result;
    }

    public void backTrack(int[] nums){
        if(tracks.size()==nums.length){
            result.add(new ArrayList<>(tracks));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(tracks.contains(nums[i])){
                continue;
            }
            tracks.add(nums[i]);
            backTrack(nums);
            tracks.removeLast();
        }
    }
}
