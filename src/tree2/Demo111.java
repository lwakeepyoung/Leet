package tree2;

import common.TreeNode;

public class Demo111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if(root.left==null || root.right==null){
            return leftMin+rightMin+1;
        }
        return Math.min(leftMin,rightMin)+1;
    }
}
