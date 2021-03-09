package 删除字符串中的所有相邻重复项;

import java.util.Stack;

/**
 * ClassName 删除字符串中的所有相邻重复项
 * Description TODO
 * Author 30712
 * Date 2021-03-08
 * Time 11:15
 */
public class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                char ch = stack.peek();
                if(ch == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        StringBuilder sb2 = new StringBuilder();
        char[] chars = sb.toString().toCharArray();
        for (int i = chars.length-1;i>=0;i--){
            sb2.append(chars[i]);
        }
        return sb2.toString();
    }
}
