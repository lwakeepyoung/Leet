package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo102_2 {

    private List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        DFS(1,root,result);
        return result;
    }

    public void DFS(int height, TreeNode root, List<List<Integer>> result){
        if(result.size()<height){
            result.add(new ArrayList<>(height));
        }
        result.get(height-1).add(root.val);
        if(root.left!=null){
            DFS(height+1,root.left,result);
        }
        if(root.right!=null){
            DFS(height+1,root.right,result);
        }
    }
}
