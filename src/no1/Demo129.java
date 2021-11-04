package no1;

import common.TreeNode;

public class Demo129 {


    public int sumNumbers(TreeNode root) {
        return dsf(root,0);
    }

    public int dsf(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        int result = sum*10+root.val;
        if(root.left==null && root.right==null){
            return result;
        }
        return dsf(root.left,result)+dsf(root.right,result);
    }


}
