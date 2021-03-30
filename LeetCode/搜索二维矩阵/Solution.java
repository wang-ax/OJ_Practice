package 搜索二维矩阵;

/**
 * ClassName 搜索二维矩阵
 * Description TODO
 * Author 30712
 * Date 2021-03-30
 * Time 22:56
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 直接暴力遍历，时间复杂度：O(n^2)
         */
       /* for(int i =0;i< matrix.length;i++){
            for (int j =0;j < matrix[0].length;j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;*/

        /**
         * 二分查找
         * 对矩阵的第一列的元素进行二分查找，找到最后一个不大于目标值的元素
         * 在该元素所在行中二分查找目标值是否存在
         */
        /*int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);*/

        /**
         * 二分查找
         */
        int m = matrix.length;
        int n = matrix[0].length;
        int low =0;
        int high =m*n-1;
        while (low <= high){
            int mid = (high - low)/2+low;
            int x = matrix[mid/n][mid %n];
            if(x < target){
                low = mid+1;
            }else if(x > target){
                high = mid-1;
            }else {
                return true;
            }
        }
        return false;
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    private  boolean binarySearchRow(int[] row,int target){
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;


    }

}
