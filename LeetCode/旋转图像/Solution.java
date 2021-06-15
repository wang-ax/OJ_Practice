package p_0607.旋转图像;

/**
 * ClassName p_0607.旋转图像
 * Description TODO
 * Author 30712
 * Date 2021-06-07
 * Time 14:33
 */
public class Solution {
    public static void rotate(int[][] matrix){
        //暴力解法
        //对于矩阵中第 i行的第 j 个元素，
        // 在旋转后，它出现在倒数第 i 列的第 j个位置。
        /*int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i =0;i< n;i++){
            for (int j =0;j < n;j++){
                res[j][n-i-1] = matrix[i][j];
            }
        }
        //由于要在原来的数组上发生改变
        for (int i =0;i < n;i++){
            for (int j =0;j<n;j++){
                matrix[i][j]= res[i][j];
            }
        }*/

        //原地进行旋转
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i =0;i< matrix.length;i++){
            for (int j =0;j < matrix.length;j++){
                System.out.println(matrix[i][j]);
            }
        }

    }
}
