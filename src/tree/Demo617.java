package tree;

import common.TreeNode;

public class Demo617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode root = new TreeNode(root1.val+root2.val);
        TreeNode left = mergeTrees(root1.left,root2.left);
        TreeNode right = mergeTrees(root1.right,root2.right);
        root.left = left;
        root.right = right;
        return root;
    }

}
