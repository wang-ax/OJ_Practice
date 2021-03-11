package 二维数组打印;

import java.util.Arrays;

/**
 * ClassName 二维数组打印
 * Description TODO
 * Author 30712
 * Date 2021-03-11
 * Time 9:06
 */

/**
 * （0，n-1）
 * （0，n-2），(0，n-1)
 * （0，n-3），(0，n-2),(0，n-1)
 * 前面是x都是0
 * 后面是y都是0
 * (1,0) (2,1) (3,2)
 * (2,0)(3,1)
 * (3,0)
 */
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] newArray= new int[n*n];
        int i =0;
        //从右上角开始进行打印，右上角的坐标（0，n-1）
        int X =0;
        int Y =n-1;

        while (X < n){
            int x = X;
            int y = Y;
            //要保证在数组内，所以组要x<n ,y < n
            while ( x < n && y < n){
                newArray[i++] = arr[x++][y++];
            }
            if (Y > 0){
                Y--;//上三角的坐标，x都是0
            }else{
                X++;
            }
        }
        return  newArray;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n =4;
        System.out.println(Arrays.toString(printer.arrayPrint(arr, n)));
    }
}
