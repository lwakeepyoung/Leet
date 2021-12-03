package tree;

import common.TreeNode;

public class Demo230 {

    public int[] num;

    public int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        num = new int[k];
        kth(root,k);
        return num[k-1];
    }

    public void kth(TreeNode root,int k){
        if(root==null) {
            return;
        }
        kth(root.left,k);
        if(index>k-1){
            return;
        }
        num[index] = root.val;
        index++;
        kth(root.right,k);
    }
}
