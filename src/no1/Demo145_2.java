package no1;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo145_2 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root==null)
            return result;
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode pop = deque.pop();
            result.add(0,pop.val);
            if(pop.left!=null){
                deque.push(pop.left);
            }
            if(pop.right!=null){
                deque.push(pop.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left =treeNode4;
        treeNode2.right  =treeNode5;
        postorderTraversal(treeNode1);
    }
}
