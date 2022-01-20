package tree2;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        Boolean flag = true;
        deque.push(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if(flag){
                    list.add(poll.val);
                }else {
                    list.add(0,poll.val);
                }
                if (poll.left!=null){
                    deque.offer(poll.left);
                }
                if(poll.right!=null){
                    deque.offer(poll.right);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }
}
