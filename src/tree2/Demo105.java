package tree2;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Demo105 {

    private Map<Integer,Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int lr){
        if(pl>pr){
            return null;
        }
        //根据preorder找出root
        int rootVal = preorder[pl];
        TreeNode rootNode = new TreeNode(rootVal);
        //在inorder根据root位置找出左节点，右节点
        int mid = indexMap.get(rootVal);
        int leftLength = mid-il;
        TreeNode leftNode = build(preorder,pl+1,pl+leftLength,inorder,il,lr+leftLength);
        TreeNode rightNode = build(preorder,pl+1+leftLength,pr,inorder,il+leftLength+1,lr);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }

    public static void main(String[] args) {
        Demo105 demo105 = new Demo105();
        TreeNode treeNode = demo105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }


}
