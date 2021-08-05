package p58翻转单词顺序;

import java.util.Stack;

/**
 * ClassName p58翻转单词顺序
 * Description TODO
 * Author 30712
 * Date 2021-06-10
 * Time 11:21
 */
public class Solution {
    public static String reverseWords(String s) {
        /**
         * 以字符为单位进行翻转字符串
         */
        //去掉前后空格
       String s1 =  s.trim();
        //从后往前入栈，碰到空格就出栈
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = s1.length()-1;i>=0;i--){
            char ch = s1.charAt(i);
            //先入栈再出栈
            stack.push(ch);
            if (ch == ' '){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        sb.append(' ');
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString().trim();

        /**
         * 以单词为单位进行翻转
         */
/*        String [] strings = s.trim().split(" ");//删除首尾空格，分割字符串
        StringBuilder sb = new StringBuilder();
        for (int i= strings.length-1;i>=0;i--){//倒序遍历单词列表
            if (strings[i].equals("")){
                continue;//遇到空单词则跳过
            }
            sb.append(strings[i]+" ");//进行单词拼接
        }
        return sb.toString().trim();//转换为字符串，删除尾部空格*/
    }

    public static void main(String[] args) {
        String  s =  "I am a student";
        System.out.println(reverseWords(s));
    }
}
