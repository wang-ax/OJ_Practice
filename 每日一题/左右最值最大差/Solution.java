package 左右最值最大差;

import java.util.Scanner;

/**
 * ClassName 左右最值最大差
 * Description TODO
 * Author 30712
 * Date 2021-03-22
 * Time 8:27
 */
public class Solution {
    //贪心算法

    public static int findMaxGap(int[] A,int n){
        //用数组的最大值减去数组两端较小的那个值
        int max = 0;
        for (int i =0;i< A.length;i++){
            if (A[i]> max){
                max = A[i];
            }
        }
        int res1 = max-A[0];
        int res2 = max-A[n-1];
        if (res1 > res2){
            return res1;
        }else {
            return res2;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i=0;i< n;i++){
            A[i] = scanner.nextInt();
        }
        int result  = findMaxGap(A,5);
        System.out.println(result);
    }
}
