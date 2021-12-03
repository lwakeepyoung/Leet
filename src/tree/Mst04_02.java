package tree;

import common.TreeNode;

public class Mst04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0,nums.length-1);
    }

    public TreeNode BST(int[] nums,int li,int ri){
        if(li>ri){
            return null;
        }
        int mid = li+(ri-li)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = BST(nums,li,mid-1);
        treeNode.right = BST(nums,mid+1,ri);
        return treeNode;
    }


}
