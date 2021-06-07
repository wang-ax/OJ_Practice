package p_0607.回溯算法.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName p_0607.回溯算法.N皇后
 * Description TODO
 * Author 30712
 * Date 2021-06-07
 * Time 17:37
 */
public class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] ch :board){
            Arrays.fill(ch,'.');//初始化棋盘
        }
        backtrack(board,0);
        return result;
    }

    private void backtrack(char[][] board, int row) {
        //满足结束条件
        if (row == board.length){
            result.add(ArrayToList(board));
            return;
        }
        int n  = board[0].length;
        for (int col =0;col <n;col++){
            if(!isValid(board,row,col)){
                continue;
            }
            //做选择
            board[row][col] ='Q';
            //进入下一行放皇后
            backtrack(board,row+1);
            //撤销选择
            board[row][col] = '.';
        }
    }
    //判断是否可以在board[row][col]放置皇后
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        //由于是从上往下开始的，所以不需要判断下面是否会有冲突
        for (int i=0;i<n;i++){
            //检查该列是否有皇后互相冲突
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for (int i = row-1,j=col+1;i>=0&& j <n ;i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        //检查左上方是否有皇后冲突
        for (int i=row-1,j=col-1;i>=0 && j >=0;i--,j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    //数组转为List
    private List<String> ArrayToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] ch : board){
            list.add(String.copyValueOf(ch));
        }
        return list;
    }
}
