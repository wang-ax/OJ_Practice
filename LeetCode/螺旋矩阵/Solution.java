package 螺旋矩阵;

/**
 * ClassName 螺旋矩阵
 * Description TODO
 * Author 30712
 * Date 2021-03-16
 * Time 20:34
 */
public class Solution {
    public int[][] generateMatrix(int n) {
      /*  //一层一层的
        int l = 0, r = n - 1, t = 0, b = n - 1;

        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;//最小是1，最大是n^2

        while(num <= tar){
            for(int i = l; i <= r; i++){
                mat[t][i] = num++;
            }
            t++;
            for(int i = t; i <= b; i++) {
                mat[i][r] = num++;
            }
            r--;
            for(int i = r; i >= l; i--) {
                mat[b][i] = num++;
            }
            b--;
            for(int i = b; i >= t; i--) {
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;*/

        int maxNum = n*n;
        int cur =1;
        int[][] matrix = new int[n][n];
        int row =0;
        int col =0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionsIndex =0;
        while (cur < maxNum){
            matrix[row][col] = cur;
            cur++;
            int nextRow = row + directions[directionsIndex][0];
            int nextColumn = col + directions[directionsIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionsIndex = (directionsIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionsIndex][0];
            col = col + directions[directionsIndex][1];

        }
        return matrix;

    }
}
