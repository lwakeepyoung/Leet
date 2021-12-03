package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2021/11/1 23:06
 */
public class Demo671 {

    public List<Integer> list = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        DSF(root);
        Collections.sort(list);
        if(list.size()>=2){
            return list.get(1);
        }
        return -1;
    }

    public void DSF(TreeNode root){
        if(root == null){
            return;
        }
        DSF(root.left);
        int var  = root.val;
        if(!list.contains(var)){
            list.add(var);
        }
        DSF(root.right);
    }

}
