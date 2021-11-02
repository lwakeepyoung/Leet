package no1;

import common.TreeNode;

public class DemoOffer54 {
    private int result =0;
    private int k = 0;
    public int kthLargest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        this.k = k;
        DSF(root);
        return result;
    }

    public void DSF(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        DSF(treeNode.right);
        k--;
        int var = treeNode.val;
        if(k==0){
            result = var;
        }
        DSF(treeNode.left);
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
        new DemoOffer54().kthLargest(treeNode1,4);
    }


}
