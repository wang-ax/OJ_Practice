package 螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName 螺旋矩阵
 * Description TODO
 * Author 30712
 * Date 2021-04-11
 * Time 22:00
 */
class Solution2 {
    //螺旋矩阵就是顺时针打印矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int[] array = Order(matrix);
        for(int i =0;i<array.length;i++){
            list.add(array[i]);
        }
        return list;
    }

    public int[] Order(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        //分层打印
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            //打印完一层之后，各个标志点进行++或者--操作
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
