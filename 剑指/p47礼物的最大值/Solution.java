package p47礼物的最大值;

/**
 * ClassName p47礼物的最大值
 * Description TODO
 * Author 30712
 * Date 2021-08-11
 * Time 12:11
 */
public class Solution {
    public int maxValue(int[][] grid) {
        //动态规划
        //dp[i][j] 代表从期盼的左上角开始，到达单元格（i，j）时能拿到礼物的最大累计价值
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0;i< m;i++){
            for (int j =0;j<n;j++){
                if (i == 0 && j == 0){
                    continue;
                }
                //为矩阵第一行元素，只可从左边到达
                if (i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if (j == 0){//为矩阵第一列元素，只可从上面到达
                    grid[i][j] += grid[i-1][j];
                }else {
                    //可以从左边或者上边到达
                    grid[i][j] += Math.max(grid[i][j-1],grid[i - 1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
