package tree;

import common.TreeNode;

/**
 * @Author: lwa
 * @Date: 2021/10/27 22:56
 */
public class Demo111 {
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int height1 = minDepth(root.left);
        int height2 = minDepth(root.right);
        if(root.left==null || root.right==null){
           return height1+height2+1;
        }
        return Math.min(height1,height2)+1;
    }

}
