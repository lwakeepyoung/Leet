package no1;

import common.TreeNode;

public class DemoOffer28 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return is(root.left,root.right);
    }

    public Boolean is(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return is(root1.left,root2.right) && is(root1.right,root2.left);
    }
}
