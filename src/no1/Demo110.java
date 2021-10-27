
package no1;

import common.TreeNode;

import javax.swing.*;

/**
 * @Author: lwa
 * 自顶向上
 * @Date: 2021/10/27 21:41
 */
public class Demo110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) {
            return true;
        }else {
            return Math.abs(height(root.left)-height(root.right))<=1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

}
