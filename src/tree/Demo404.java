package tree;

import common.TreeNode;

public class Demo404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return root!=null?build(root):0;
    }

    public int build(TreeNode root){
        int ans = 0;
        if(root.left!=null){
            ans += isLeafNode(root.left)?root.left.val:build(root.left);
        }
        if(root.right!=null && !isLeafNode(root.right)){
            ans += build(root.right);
        }
        return ans;
    }

    private Boolean isLeafNode(TreeNode root){
        return root.left==null&& root.right==null;
    }


}
