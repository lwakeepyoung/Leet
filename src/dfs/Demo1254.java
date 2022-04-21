package dfs;

public class Demo1254 {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //淹掉上边和下边的岛屿
        for (int j = 0; j < n; j++) {
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        //淹掉左边和右边的岛屿
        for (int i = 0; i < m; i++) {
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        int result = 0;
        //统计孤立岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    result++;
                    //dfs
                    dfs(grid,i,j);
                }

            }
        }
        return result;
    }

    public void dfs(int[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        //超出边界
        if(i<0 || j<0 || i>=m || j>=n){
            return;
        }
        //已经是海水了
        if(grid[i][j]==1){
            return;
        }
        grid[i][j] = 1;
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }


}
