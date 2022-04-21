package dfs;

public class Demo200_2 {
        public int numIslands(char[][] grid) {
            int result = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j]=='1'){
                        result++;
                        //dfs
                        dfs(grid,i,j);
                    }

                }
            }
            return result;
        }

        public void dfs(char[][] grid,int i,int j){
            int m = grid.length;
            int n = grid[0].length;
            //判断越界
            if(i<0 || j<0 || i>=m || j>=n){
                return;
            }
            //判断是否访问过
            if(grid[i][j]=='0'){
                return;
            }
            grid[i][j]='0';
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
            dfs(grid,i-1,j);
            dfs(grid,i,j-1);
        }
}
