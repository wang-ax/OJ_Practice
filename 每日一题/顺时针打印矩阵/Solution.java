package 顺时针打印矩阵;

import java.util.ArrayList;

/**
 * ClassName 顺时针打印矩阵
 * Description TODO
 * Author 30712
 * Date 2021-03-22
 * Time 8:59
 */
public class Solution {
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        // write code here
        int[] array = new int[n*m];
        int row1 = 0,row2 = mat.length-1;
        int col1 = 0,col2 = mat[0].length-1;
        while (col1 <= col2 && row1 <= row2){
            if (row1 == row2){//只有一行
                for (int i= col1 ;i <=col2;i++){
                    list.add(mat[row1][i]);
                }
            }else if(col1 == col2){//只有1列
                for (int i = row1 ; i<=row2;i++){
                    list.add(mat[i][col1]);
                }
            }else {
                int currentC = col1;
                int currentR = row1;
                //从左到右打印
                while (currentC < col2){
                    list.add(mat[row1][currentC]);
                    currentC++;
                }
                //从上到下打印
                while (currentR < row2){
                    list.add(mat[currentR][col2]);
                    currentR++;
                }
                //从右到左打印
                while (currentC > col1){
                    list.add(mat[row2][currentC]);
                    currentC--;
                }
                //从下到上打印
                while (currentR > row1){
                    list.add(mat[currentR][col1]);
                    currentR--;
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] array ={{4,46,89},{28,66,99},{26,21,71}};
        int m =3;
        int n =3;
        int [] result = clockwisePrint(array,m,n);
        for (Integer e : result){
            System.out.println(e);
        }

    }
}
