package tree;

import common.TreeNode;

public class Demo572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) || isSame(root,subRoot);
    }

    public boolean isSame(TreeNode a,TreeNode b){
        if(a==null && b ==null){
            return true;
        }
        if(a==null || b == null){
            return false;
        }
        if(a.val != b.val){
            return false;
        }
        return isSame(a.left,b.left) && isSame(a.right,b.right);
    }



}
