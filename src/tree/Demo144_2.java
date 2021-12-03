package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2021/10/24 17:40
 */
public class Demo144_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pop();
            result.add(node.val);
            if(node.right!=null){
                deque.push(node.right);
            }
            if(node.left!=null){
                deque.push(node.left);
            }
        }
        return result;
    }
}
