import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class common.TreeNode {
 *     int val;
 *     common.TreeNode left;
 *     common.TreeNode right;
 *     common.TreeNode(int x) { val = x; }
 * }
 */
class Demo_offer_55 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}