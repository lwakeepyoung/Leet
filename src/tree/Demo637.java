package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int length = deque.size();
            Double sum = 0d;
            for (int i = 0; i < length; i++) {
                TreeNode poll = deque.poll();
                sum += poll.val;
                if(poll.left!=null){
                    deque.offer(poll.left);
                }
                if (poll.right!=null){
                    deque.offer(poll.right);
                }
            }
            result.add(sum/length);
        }
        return result;
    }

}
