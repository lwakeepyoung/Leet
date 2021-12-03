package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2021/11/1 23:06
 */
public class Demo671_2 {

    private List<Integer> list =new ArrayList<>();

    public int findSecondMinimumValue(TreeNode root) {
        DSF(root);
        if(list.size()>=2){
            return list.get(1);
        }
        return -1;
    }

    public void DSF(TreeNode root){
        if(root == null){
            return;
        }
        int value = root.val;
        if(!list.contains(value)){
            list.add(value);
        }
        DSF(root.left);
        DSF(root.right);
    }

}
