package no1;

import common.TreeNode;

public class Demo993 {
    public int xDep;
    public int yDep;
    public int xPre;
    public int yPre;
    public int x;
    public int y;
    public boolean xFound;
    public boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        cousins(root,0,-1);
        return xDep==yDep && xPre!=yPre;
    }

    public void cousins(TreeNode root,int dep,int parent){
        if(root == null){
            return;
        }
        int value = root.val;
        if(value==x){
            xPre = parent;
            xDep = dep;
            xFound = true;
        }
        if(value == y){
            yPre = parent;
            yDep = dep;
            yFound = true;
        }
        if(xFound && yFound){
            return;
        }
        cousins(root.left,dep+1,root.val);
        if(xFound && yFound){
            return;
        }
        cousins(root.right,dep+1,root.val);
    }





}
