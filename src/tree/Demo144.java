package tree;//给定一个二叉树，返回它的 前序 遍历。
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
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 354 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class common.TreeNode {
 *     int val;
 *     common.TreeNode left;
 *     common.TreeNode right;
 *     common.TreeNode(int x) { val = x; }
 * }
 */
class Demo144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }


    public void preorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
