package no1;

import common.TreeNode;

public class Demo543 {

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDep(root);
        return max-1;
    }
    public int maxDep(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = maxDep(root.left);
        int right = maxDep(root.right);
        max = Math.max(max,left+right+1);
        return Math.max(left,right)+1;
    }


}
