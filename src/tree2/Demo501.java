package tree2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo501 {

    private List<Integer> result = new ArrayList<>();

    //众数
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

    private void dsf(TreeNode root){
        if(root==null){
            return;
        }
        dsf(root.left);
        update(root.val);
        dsf(root.right);
    }

    private void update(int val) {
        if(val==base){
            ++count;
        }else {
            count = 1;
            base = val;
        }
        if(count == maxCount){
            result.add(val);
        }else if(count>maxCount){
            maxCount = count;
            result.clear();
            result.add(base);
        }
    }
}
