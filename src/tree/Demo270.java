package tree;

import common.TreeNode;

public class Demo270 {

    private double min = Integer.MAX_VALUE;

    private int result = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        dsf(root,target);
        return result;
    }

    public void dsf(TreeNode root,double target){
        if(root==null){
            return;
        }
        if(root.val>target){
            dsf(root.left,target);
        }
        double diff = diff(root.val,target);
        if(diff<min){
            min = diff;
            result = root.val;
        }
        if(root.val<target){
            dsf(root.right,target);
        }
    }

    public double diff(double a,double b){
        if(a>b){
            return a-b;
        }
        return b-a;
    }
}
