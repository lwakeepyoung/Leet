package no1;

import common.TreeNode;

import java.util.*;

/**
 * @Author: lwa
 * @Date: 2021/10/24 21:12
 */
public class Demo94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr!=null || !deque.isEmpty()){
            while (curr!=null){
                deque.push(curr);
                curr = curr.left;
            }
            curr = deque.poll();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

}
