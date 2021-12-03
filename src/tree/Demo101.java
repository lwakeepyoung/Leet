//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1583 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package tree;

import common.TreeNode;

public class Demo101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode root1,TreeNode root2){
        if (root1==null && root2 == null){
            return true;
        }
        if (root1==null || root2 == null){
            return false;
        }
        return check(root1.left,root2.right) && check(root1.right,root2.left) && root1.val==root2.val;
    }
}
