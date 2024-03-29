package tree2;

import common.Node;

public class Demo116 {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        connectTwo(root.left,root.right);
        return root;
    }

    public void connectTwo(Node left,Node right){
        if(left==null || right==null){
            return;
        }
        left.next = right;
        connectTwo(left.left,left.right);
        connectTwo(right.left,right.right);
        connectTwo(left.right,right.left);
    }
}
