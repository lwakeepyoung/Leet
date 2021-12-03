package tree;

import common.TreeNode;

public class DemoOffer55 {

    private boolean isBalanced=true;

    public boolean isBalanced(TreeNode root) {
        DSF(root);
        return isBalanced;
    }
    public int DSF(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = DSF(root.left);
        int right = DSF(root.right);
        if(Math.abs(left-right)>1){
            isBalanced = false;
        }
        return Math.max(left,right)+1;
    }

}
