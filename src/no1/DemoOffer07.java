package no1;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DemoOffer07 {
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
           map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int pl,int pr,
                          int[] inorder,int il,int ir){
        if(pl>pr){
            return null;
        }
        int rootValue = preorder[pl];
        TreeNode treeNode = new TreeNode(rootValue);
        int index = map.get(rootValue);
        int leftLength = index-il;
        int rightLength = ir-index;
        TreeNode left = build(preorder,pl+1,pl+leftLength,inorder,il,il+leftLength);
        TreeNode right = build(preorder,pl+leftLength+1,pr,inorder,index+1,ir);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }



}
