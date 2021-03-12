package 连续最大和;

import java.util.Scanner;

/**
 * ClassName 连续最大和
 * Description TODO
 * Author 30712
 * Date 2021-03-12
 * Time 8:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//元素的个数
        int[] arr = new int[n];
        for (int i=0;i< n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int max =arr[0];
        int sum =0;
        for (int i=0;i< arr.length;i++){
            if (sum < 0){
                sum =0;
            }
            sum  +=arr[i];
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
}
