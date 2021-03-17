package 骆驼命名法;

import java.util.Scanner;

/**
 * ClassName 骆驼命名法
 * Description TODO
 * Author 30712
 * Date 2021-03-17
 * Time 9:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            StringBuilder stringBuilder = new StringBuilder();
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            for (int i =0;i< chars.length;i++){
                if (chars[i] == '_'){
                    chars[i+1] = (char) (chars[i+1]-32);
                }else {
                    stringBuilder.append(chars[i]);
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
