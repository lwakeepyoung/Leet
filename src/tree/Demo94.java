//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 650 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package tree;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class common.TreeNode {
 *     int val;
 *     common.TreeNode left;
 *     common.TreeNode right;
 *     common.TreeNode(int x) { val = x; }
 * }
 */
public class Demo94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    public void inorder(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
