package no1;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2021/11/1 23:37
 */
public class Demo872_1 {



    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1==null && root2 ==null) {
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }

        List<Integer> list1 =new ArrayList<>();
        List<Integer> list2 =new ArrayList<>();
        DSF(root1,list1);
        DSF(root2,list2);
        return list1.equals(list2);
    }

    public void DSF(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        DSF(root.left,list);
        DSF(root.right,list);
        if (root.left==null && root.right==null){
            list.add(root.val);
        }
    }


}
