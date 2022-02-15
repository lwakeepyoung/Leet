package tree2;

import common.TreeNode;

public class Demo222 {
    public int countNodes(TreeNode root) {
//        TreeNode leftTree = root;
//        TreeNode rightTree = root;
//        int hl = 0;
//        int hr = 0;
//        while (leftTree!=null){
//            leftTree = leftTree.left;
//            hl++;
//        }
//        while (rightTree!=null){
//            rightTree = rightTree.right;
//            hr++;
//        }
//
//        if(hl==hr){
//            return (int)Math.pow(2,hl)-1;
//        }
        return 1+countNodes(root.left)+countNodes(root.right);

    }

}
