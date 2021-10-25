package no1;//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 660 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class common.TreeNode {
 *     int val;
 *     common.TreeNode left;
 *     common.TreeNode right;
 *     common.TreeNode(int x) { val = x; }
 * }
 */
class Demo105 {

    private Map<Integer,Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int pl,int pr,
                          int[] inorder, int il,int ir){
        if(pl>pr){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int leftNodeLength = indexMap.get(preorder[pl])-il;
        root.left = build(preorder,pl+1,pl+leftNodeLength,inorder,il,il+leftNodeLength);
        root.right = build(preorder,pl+1+leftNodeLength,pr,inorder,il+1+leftNodeLength,ir);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
