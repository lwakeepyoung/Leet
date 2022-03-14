package backtrack;

import java.util.LinkedList;
import java.util.List;

public class Demo46 {

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(track,nums);
        return res;
    }


    private  static void backTrack(LinkedList<Integer> track, int[] nums) {
        //条件结束，加到最终返回结果中
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(track,nums);
            //取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
