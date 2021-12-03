
package tree;

import common.TreeNode;

/**
 * @Author: lwa
 * 自顶向上
 * @Date: 2021/10/27 21:41
 */
public class Demo110_1 {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        if(leftHeight==-1){
            return -1;
        }
        int rightHeight = height(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }

}
