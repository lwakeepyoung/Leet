package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo77 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> track = new LinkedList();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,0);
        return result;
    }

    private void backtrack(int n, int k,int start) {
        if(track.size()==k){
            result.add(new LinkedList<>(track));
        }

        for (int i = start; i <= n; i++) {
            //加入路径
            track.add(i);
            backtrack(n,k,i+1);
            track.removeLast();
        }
    }
}
