package backtrack;

import java.util.LinkedList;
import java.util.List;

public class Demo46_2 {

    List<List<Integer>> res =new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //结束条件
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        //选择路径
        for (int i = 0; i < nums.length; i++) {
            //过滤重复数字
            if(track.contains(nums[i])){
                continue;
            }
            //选择路径
            track.add(nums[i]);
            //进入下一层决策数
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }
    }
}
