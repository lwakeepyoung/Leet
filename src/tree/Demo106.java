package tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Demo106 {

    private Map<Integer,Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        //用于快速获取根节点元素
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode build(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (il>ir || pl>pr){
            return null;
        }
        //寻找根元素节点
        int rootVal = postorder[pr];
        int i_rootIndex =map.get(rootVal);
        //计算left长度
        int leftNodeLength = i_rootIndex-il;

        TreeNode rootNode = new TreeNode(rootVal);
        //构建left node
        rootNode.left = build(inorder,il,i_rootIndex-1,postorder,pl,pl+leftNodeLength-1);
        //构建right node
        rootNode.right = build(inorder,i_rootIndex+1,ir,postorder,pl+leftNodeLength,pr-1);
        return rootNode;
    }
}
