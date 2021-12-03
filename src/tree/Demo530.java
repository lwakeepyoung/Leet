package tree;

import common.TreeNode;

public class Demo530 {

    public int minDiff = Integer.MAX_VALUE;

    private int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        DSF(root);
        return minDiff;
    }

    public void DSF(TreeNode root){
        if(root==null){
            return;
        }
        DSF(root.left);
        if(pre!=-1){
            minDiff = Math.min(minDiff,root.val-pre);
        }
        pre = root.val;
        DSF(root.right);
    }


}
