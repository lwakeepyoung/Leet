package tree;

import common.TreeNode;

public class Demo783 {
    private int minDiff = Integer.MAX_VALUE;
    private int pre = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    public void dfs(TreeNode root){
        if (root==null){return;}
        dfs(root.left);
        if(pre >=0){
            minDiff = Math.min(minDiff,root.val-pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
