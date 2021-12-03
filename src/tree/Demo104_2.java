package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo104_2 {
    public int maxDepth(TreeNode root) {
        int result = 0;
        if(root==null){
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()){
            result++;
            int length = stack.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = stack.poll();
                if(treeNode.left!=null){
                    stack.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    stack.offer(treeNode.right);
                }

            }
        }
        return result;
    }
}
