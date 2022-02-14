package tree2;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                list.add(treeNode.val);
                if(treeNode.left!=null){
                    deque.offerLast(treeNode.left);
                }
                if(treeNode.right!=null){
                    deque.offerLast(treeNode.right);
                }
            }
            result.add(0,list);
        }
        return result;
    }
}
