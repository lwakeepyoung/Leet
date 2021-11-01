package no1;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lwa
 * @Date: 2021/11/1 22:33
 */
public class Demo653 {

    private Map<Integer,Integer> map;

    private Boolean result = false;

    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<>();
        DSF(root,k);
        return result;
    }

    public void DSF(TreeNode root, int k){
        if(root == null){
            return;
        }
        DSF(root.left,k);
        int curr = root.val;
        int target = k - curr;
        if(map.get(curr) == null) {
            map.put(target, curr);
        }else {
            result = true;
        }
        DSF(root.right,k);
    }
}
