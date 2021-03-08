package 删除最外层的括号;

import java.util.Stack;

/**
 * ClassName 删除最外层的口号
 * Description TODO
 * Author 30712
 * Date 2021-03-08
 * Time 7:45
 */
public class Solution {
    public String removeOuterParentheses(String S) {
        /**
         * 使用栈结构
         */
        StringBuilder stringBuilder = new StringBuilder();
        //利用栈来保存左括号
        //判断是不是最外层的括号：左括号入栈前栈为空，右括号加入并消除括号后，栈为空
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()){
            if (stack.isEmpty() && c == '('){//当栈为空时，碰到左括号就入栈
                stack.push(c);
            }else if (!stack.isEmpty() && c == '('){//栈不为空，且遇到左括号
                //先将左括号入栈
                stack.push(c);
                //向stringBuilder中添加遇到的左括号
                stringBuilder.append(c);
            }
            if (c == ')'){
                stack.pop();
                //如果栈为空说明是最外层的口号
                if (!stack.isEmpty()){//不为空就添加到stringBuilder中
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
        /**
         *
         */
       /* StringBuilder stringBuilder = new StringBuilder();
        int level =0;
        for (char c:S.toCharArray()){
            if (c == ')'){
                --level;
            }
            if (level>=1){
                stringBuilder.append(c);
            }
            if (c == '('){
                ++level;
            }
        }
        return stringBuilder.toString();*/
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses(s));
    }
}
