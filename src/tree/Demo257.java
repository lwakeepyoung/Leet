package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo257 {

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            dsf(root,result,"");
            return result;
        }

        public void dsf(TreeNode root,List<String> result, String path){
            if(root == null){
                return ;
            }
            StringBuffer stringBuffer = new StringBuffer(path);
            stringBuffer.append(root.val+"");
            //当前节点是叶子节点
            if(root.left==null&&root.right==null){
                result.add(stringBuffer.toString());
            }else {
                stringBuffer.append("->");
                dsf(root.left,result,stringBuffer.toString());
                dsf(root.right,result,stringBuffer.toString());
            }
        }




}
