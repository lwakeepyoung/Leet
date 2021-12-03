package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2021/11/1 23:37
 */
public class Demo872 {

    public List<Integer> list =new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        DSF(root1,s1);
        DSF(root2,s2);
        if(s1.toString().equals(s2.toString())){
            return true;
        }
        return false;
    }

    public void DSF(TreeNode root,StringBuffer path){
        if (root==null){
            return;
        }
        DSF(root.left,path);
        DSF(root.right,path);
        if(root.left==null && root.right==null){
            path.append(root.val+"_");
        }
    }
}
