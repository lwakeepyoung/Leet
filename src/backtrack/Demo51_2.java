package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo51_2 {

    List<List<String>> res = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i],'.');
        }
        backTrack(board,0);
        return res;
    }

    public void backTrack(char[][] board,int row){
        //当前行存在一个皇后
        if(board.length==row){
            res.add(charToList(board));
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            //排除可以互相攻击的棋子
            if(!isValid(board,row,col)){
                continue;
            }
            //当前行放置皇后
            board[row][col] = 'Q';
            //下一行放置皇后
            backTrack(board,row+1);
            //取消放置
            board[row][col] = '.';
        }
    }

    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    /* 判断是否可以在 board[row][col] 放置皇后 */
    public Boolean isValid(char[][] board,int row,int col){
        int n = board.length;
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for (int i = row-1,j=col+1; i >=0&&j<n ; i--,j++) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //检查左上方是否有皇后冲突
        for (int i = row-1,j=col-1; i >=0&&j>=0 ; i--,j--) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

}
