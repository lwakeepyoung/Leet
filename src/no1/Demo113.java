package no1;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo113 {

    private List<List<Integer>> result =  new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,0,new ArrayList<>());
        return result;
    }

    public int helper(TreeNode treeNode,int targetSum,int sum,List<Integer> list){
        if(treeNode==null){
            return 0;
        }
        sum +=treeNode.val;
        list.add(treeNode.val);
        if(treeNode.left==null&& treeNode.right==null){
            if(sum==targetSum){
                result.add(new ArrayList<>(list));
            }
        }
        int left = helper(treeNode.left,targetSum,sum,list);
        int right = helper(treeNode.right,targetSum,sum,list);
        list.remove(list.size() - 1);
        return left+right;
    }

}
