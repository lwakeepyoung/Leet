package no1;

import common.TreeNode;

public class Demo124 {

    public Integer max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        DSF(root);
        return max;
    }

    public int DSF(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,DSF(root.left));
        int right = Math.max(0,DSF(root.right));
        max = Math.max(max,left + right +root.val);
        return Math.max(left,right)+root.val;
    }


}
