package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo46_4 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> tracks =new LinkedList<>();
        backTrack(nums,tracks);
        return result;
    }

    public void backTrack(int[] nums,LinkedList<Integer> tracks){
        if(tracks.size()==nums.length){
            result.add(new ArrayList<>(tracks));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(tracks.contains(nums[i])){
                continue;
            }
            //加入选择
            tracks.add(nums[i]);
            //选择下一层级
            backTrack(nums,tracks);
            //取消选择
            tracks.removeLast();
        }
    }
}
