package no1;
//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 324 👎 0


import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Demo652 {

    //判断节点是否存在
    private Map<String,Integer> count;

    private List<TreeNode> treeNodes;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        treeNodes = new ArrayList<>();
        findDuplicate(root);
        return treeNodes;
    }

    public String findDuplicate(TreeNode root){
        if(root==null){
            return "#";
        }

        String left = findDuplicate(root.left);
        String right = findDuplicate(root.right);

        String key = left+"_"+right+"_"+root.val;
        Integer num = count.get(key);
        if(num!=null){
            if(num==1){
                treeNodes.add(root);
            }
        }
        count.put(key,count.getOrDefault(key,0)+1);
        return key;
    }

}
