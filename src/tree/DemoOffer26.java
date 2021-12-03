package tree;

import common.TreeNode;

public class DemoOffer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null){
            return false;
        }
        if(A==null){
            return false;
        }
        return isSame(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean isSame(TreeNode a,TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
            return false;
        }
        if(a.val!=b.val){
            return false;
        }
        return isSame(a.left,b.left) && isSame(a.right,b.right);
    }


}
