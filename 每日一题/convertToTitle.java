package p_0629;

import java.util.Scanner;

/**
 * ClassName p_0629
 * Description TODO  168. Excel表列名称
 * Author 30712
 * Date 2021-06-29
 * Time 14:45
 */
public class convertToTitle {
    public static String convertToTitle(int columnNumber){
        if (columnNumber <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while ( columnNumber > 0){
            //Excel中的数字是从1开始的
            columnNumber--;
            sb.append((char)(columnNumber %26 + 'A'));
            columnNumber = columnNumber/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(convertToTitle(n));
    }
}
