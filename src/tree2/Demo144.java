package tree2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
}
