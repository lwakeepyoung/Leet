package tree;

import com.sun.org.apache.bcel.internal.generic.IINC;
import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo102_4 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(result==null){
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if(pop.left!=null){
                    stack.offer(pop.left);
                }
                if(pop.right!=null){
                    stack.offer(pop.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
