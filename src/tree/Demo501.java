package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo501 {
    private List<Integer> result = new ArrayList<>();

    private int maxCount;
    private int count;
    private int base;

    public int[] findMode(TreeNode root) {
        dsf(root);
        int[] r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public void dsf(TreeNode root){
        if(root==null){
            return;
        }
        dsf(root.left);
        update(root.val);
        dsf(root.right);
    }

    public void update(int val){
        if(base==val){
            ++count;
        }else {
            count = 1;
            base = val;
        }
        if(count == maxCount){
            result.add(val);
        }
        if(count>maxCount){
            maxCount = count;
            result.clear();
            result.add(base);
        }
    }



}
