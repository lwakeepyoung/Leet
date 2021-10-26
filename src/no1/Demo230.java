package no1;

import common.TreeNode;

import java.util.List;

public class Demo230 {

    public int[] num;

    public int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        num = new int[k];
        kth(root,k);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        return num[index];
    }

    public void kth(TreeNode root,int k){
        if(root==null || index==k-1) {
            return;
        }
        kth(root.left,k);
        num[index] = root.val;
        index++;
        kth(root.right,k);
    }
}
