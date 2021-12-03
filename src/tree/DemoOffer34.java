package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DemoOffer34 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        DSF(root,target,0);
        return result;
    }

    public int DSF(TreeNode treeNode,int target,int sum){
        if(treeNode==null){
            return 0;
        }
        sum += treeNode.val;
        list.add(treeNode.val);
        int left = DSF(treeNode.left,target,sum);
        int right = DSF(treeNode.right,target,sum);
        if(treeNode.left==null && treeNode.right==null){
            if(target==sum){
                result.add(new ArrayList<>(list));
            }
        }
        list.remove(list.size()-1);
        return left+right;
    }
}
