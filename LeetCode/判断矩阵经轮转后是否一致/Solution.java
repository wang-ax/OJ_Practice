package p_0607.判断矩阵经轮转后是否一致;

import java.util.Arrays;

/**
 * ClassName p_0607.判断矩阵经轮转后是否一致
 * Description TODO
 * Author 30712
 * Date 2021-06-07
 * Time 16:08
 */
 public class Solution {
    public static boolean findRotation(int[][] mat, int[][] target) {
        //旋转四次
        int temp;
        int n = mat.length;
        for (int k = 0; k < 4; k++) {
            // 旋转操作
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < (n + 1) / 2; ++j) {
                    temp = mat[i][j];
                    mat[i][j] = mat[n-1-j][i];
                    mat[n-1-j][i] = mat[n-1-i][n-1-j];
                    mat[n-1-i][n-1-j] = mat[j][n-1-i];
                    mat[j][n-1-i] = temp;
                }
            }
            //判断两个矩阵是否相等，不能直接使用==进行判断
            if(Arrays.deepEquals(mat,target)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};
        System.out.println(findRotation(mat, target));
    }
}