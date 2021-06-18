package p12矩阵中的路径;

/**
 * ClassName p12矩阵中的路径
 * Description TODO
 * Author 30712
 * Date 2021-06-18
 * Time 16:59
 */
public class Solution {
    //DFS + 回溯
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (board == null || word == null || m == 0 || n ==0 || word.length() >(n*m)){
            return false;
        }
        //深度遍历
        for (int i=0;i<m;i++){
            for (int j =0;j<n;j++){
                //从网格的任意一个位置开始进行查找
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
        //越界情况
        if (i < 0 || j < 0 || i >=board.length || j >= board[i].length || board[i][j] != word.charAt(k)){
            return false;
        }
        if(k == word.length() - 1) return true; // 说明word中的字符全部被匹配
        board[i][j] = '#';
        //做选择
        boolean res = backtrack(board,i,j+1,word,k+1) || backtrack(board,i+1,j,word,k+1)
                || backtrack(board,i-1,j,word,k+1) || backtrack(board,i,j-1,word,k+1);

        board[i][j] = word.charAt(k);//撤销选择
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','D','E'}};
        String word = "ABCCED";
        Solution solution = new Solution();
        solution.exist(board,word);
    }
}
