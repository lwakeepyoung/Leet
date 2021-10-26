package no1;

import common.TreeNode;

import java.util.List;

public class Demo230 {

    public int[] num;

    public int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        num = new int[k];
        kth(root,k);
        return num[index];
    }

    public void kth(TreeNode root,int k){
        if(root==null) {
            return;
        }
        kth(root.left,k);
        if(num.length==k){
            return;
        }
        num[index] = root.val;
        index++;
        kth(root.right,k);
    }
}
