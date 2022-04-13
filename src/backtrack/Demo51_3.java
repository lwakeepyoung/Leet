package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo51_3 {

    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i],'.');
        }
        backTrack(board,0);
        return result;
    }

    public void backTrack(char[][] board,int row){
        //结束条件 所有行都放上皇后了
        if(board.length == row){
            result.add(charToList(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            //校验是否符合条件
            if(!isValid(board,row,col)){
                continue;
            }
            //放置皇后到当前行
            board[row][col]='Q';
            //放置皇后到下一行
            backTrack(board,row+1);
            //取消选择
            board[row][col]='.';
        }


    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        //判断列皇后冲突
        for (int i = 0; i < n; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //判断右上方皇后冲突
        for (int i = row-1,j=col+1; i >= 0&& j<n ; i--,j++) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //判断左上方皇后冲突
        for (int i = row-1,j=col-1; i >=0&&j>=0 ; i--,j--) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> charToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(String.valueOf(board[i]));
        }
        return list;
    }

}
