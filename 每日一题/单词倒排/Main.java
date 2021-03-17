package 单词倒排;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName 单词倒排
 * Description TODO
 * Author 30712
 * Date 2021-03-17
 * Time 9:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s =scanner.nextLine();
            System.out.println(reverseSentence(s));
        }
    }

    private static String reverseSentence(String s) {
        //
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = chars.length-1;i>=0;i--){

            //遇到空格就将前面的元素全部出栈
            if (chars[i] == ' ' ){
                while (!stack.isEmpty()  ){
                    char c  = stack.pop();
                    stringBuilder.append(c);
                }
                stringBuilder.append(chars[i]);
            }else {
                stack.push(chars[i]);
            }

            if (i == 0){
                while (!stack.isEmpty()  ){
                    char c  = stack.pop();
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}
