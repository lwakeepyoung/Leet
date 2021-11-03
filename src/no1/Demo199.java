package no1;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo199 {

    private List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = deque.poll();
                if(curr.left!=null){
                    deque.offer(curr.left);
                }
                if(curr.right!=null){
                    deque.offer(curr.right);
                }
                if(i==size-1){
                    result.add(curr.val);
                }
            }

        }
        return result;
    }


}
