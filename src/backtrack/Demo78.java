package backtrack;

import java.util.LinkedList;
import java.util.List;

public class Demo78 {
    /**
     * [1,2,3]
     *
     * @param nums
     * @return
     */

    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            //选择路径
            track.addLast(nums[i]);
            //进入下一层决策树
            backtrack(nums,i+1);
            //取消选择
            track.removeLast();
        }
    }


}
