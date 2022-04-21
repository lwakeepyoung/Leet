package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo77_2 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> tracks = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,0);
        return result;
    }

    public void backTrack(int n,int k,int start){
        if(tracks.size()==k){
            result.add(new ArrayList<>(tracks));
            return;
        }

        for (int i = start; i < n; i++) {
            tracks.add(i);
            backTrack(n,k,i+1);
            tracks.removeLast();
        }
    }
}
