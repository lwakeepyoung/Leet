package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int length = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = deque.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null){
                    deque.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    deque.offer(treeNode.right);
                }
            }
            result.add(0,list);
        }
        return result;
    }
}
