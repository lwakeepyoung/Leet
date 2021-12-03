package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DemoOffer32_I {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return new int[]{};
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = deque.poll();
                list.add(curr.val);
                if(curr.left!=null){
                    deque.offer(curr.left);
                }
                if(curr.right!=null){
                    deque.offer(curr.right);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
