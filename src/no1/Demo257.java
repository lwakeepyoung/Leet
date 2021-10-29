package no1;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        return dsf(root,result,null);
    }

    public List<String> dsf(TreeNode root,List<String> result, String path){
        if(root == null){
            return result;
        }
        path = root.val+"";
        result.add(path);
        List<String> left = dsf(root.left,result,path);
        List<String> right = dsf(root.right,result,path);


        return result;
    }




}
