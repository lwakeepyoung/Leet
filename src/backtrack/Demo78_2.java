package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo78_2 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return result;
    }

    public void backtrack(int[] nums, int start){
        result.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            //选择路径
            track.add(nums[i]);
            //进入下级决策
            backtrack(nums,i+1);
            //取消选择
            track.removeLast();
        }
    }

}
