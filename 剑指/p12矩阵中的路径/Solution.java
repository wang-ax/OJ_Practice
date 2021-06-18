package p12矩阵中的路径;

/**
 * ClassName p12矩阵中的路径
 * Description TODO
 * Author 30712
 * Date 2021-06-18
 * Time 16:59
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i=0;i<m;i++){
            for (int j =0;j<n;j++){
                //从网格的任意一个位置开始进行查找
                //回溯
                //只要有一条路走通了，直接返回
                if (backtrack(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board 网格
     * @param i 当前行
     * @param j 当前列
     * @param word 要匹配的字符串
     * @param k 当前匹配到字符串word的位置
     * @return
     */
    private boolean backtrack(char[][] board, int i, int j, String word, int k) {
    }
}
