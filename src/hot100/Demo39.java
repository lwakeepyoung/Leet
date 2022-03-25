package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo39 {
    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0){
            return result;
        }
        backTrack(candidates,target,0,0);
        return result;
    }

    private void backTrack(int[] candidates, int target, int sum,int start) {
        if(sum==target){
            result.add(new ArrayList<>(track));
            return;
        }

        if(sum>target){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            sum+=candidate;
            track.add(candidate);
            backTrack(candidates,target,sum,i);
            //撤回操作
            sum-=candidate;
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        new Demo39().combinationSum(new int[]{2,3,6},7);
    }

}
