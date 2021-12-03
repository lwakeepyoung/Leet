package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DemoOffer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode curr = deque.poll();
            if(curr.left!=null){
                deque.offer(curr.left);
            }
            if(curr.right!=null){
                deque.offer(curr.right);
            }
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }
        return root;
    }


}
