package no1;

import common.TreeNode;

import java.util.*;

public class Demo102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root ==null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.poll();
                list.add(pop.val);
                if(pop.left!=null){
                    deque.offer(pop.left);
                }
                if(pop.right!=null){
                    deque.offer(pop.right);
                }
            }
            result.add(list);
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
        levelOrder(treeNode1);
    }
}
