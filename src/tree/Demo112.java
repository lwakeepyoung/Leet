package tree;

import common.TreeNode;

/**
 * @Author: lwa
 * @Date: 2021/10/27 23:12
 */
public class Demo112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return count(root,targetSum);
    }
    public boolean count(TreeNode root,int targetSum){
        if(root==null){
            return false;
        }
        targetSum -= root.val;
        if(targetSum==0){
            if(root.left==null && root.right == null){
                return true;
            }
        }
        return count(root.left,targetSum) || count(root.right,targetSum);
    }

}
