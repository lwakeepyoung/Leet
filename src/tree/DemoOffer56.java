package tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DemoOffer56 {
    public Map<Integer,Integer> map;

    public Boolean result = false;

    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<>();
        DSF(root,k);
        return result;
    }

    public void DSF(TreeNode root,int k){
        if(root==null){
            return;
        }
        DSF(root.left,k);
        int value = root.val ;
        if(map.get(value)==null){
            map.put(k-value,value);
        }else {
            result = true;
            return;
        }
        DSF(root.right,k);
    }


}
