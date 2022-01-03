package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2022/1/1 18:15
 */
public class Demo_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root ==null){
            return result;
        }
        Deque<TreeNode> deque =new ArrayDeque();
        deque.add(root);
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList();
            int size  = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = deque.pop();
                list.add(tree.val);
                if(tree.left!=null){
                    deque.offer(tree.left);
                }
                if(tree.right!=null){
                    deque.offer(tree.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
