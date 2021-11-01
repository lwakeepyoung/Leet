package no1;

import common.TreeNode;

import java.util.*;

/**
 * @Author: lwa
 * @Date: 2021/11/2 0:04
 */
public class DemoOffer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
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
            result.add(list);
        }
        return result;
    }
}
