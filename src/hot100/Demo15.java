package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo15 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return result;
        }
        Arrays.sort(nums);

        return result;
    }

    private void addList(int first, int second, int three) {
        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(three);
        result.add(list);
    }


}
