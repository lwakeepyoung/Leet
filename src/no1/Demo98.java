package no1;

import common.TreeNode;

public class Demo98 {

    private TreeNode pre=null;

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(pre!=null){
            if(root.val<=pre.val){
                return false;
            }
        }
        pre = root;
        return isValidBST(root.right);
    }

}
