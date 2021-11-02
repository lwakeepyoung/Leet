package no1;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DemoOffer27_2 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }



}
