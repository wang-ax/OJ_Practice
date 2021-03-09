package 棒球比赛_计算得分;

import java.util.Stack;

/**
 * ClassName 棒球比赛_计算得分
 * Description TODO
 * Author 30712
 * Date 2021-03-08
 * Time 11:31
 */
public class Solution {
    public int calPoints(String[] ops) {
        //使用栈，栈中只保存的是数字
        Stack<Integer> stack = new Stack<>();
        for (String e : ops){
            if (e .equals("C")){//直接删除栈顶的元素即可
                stack.pop();
            }else if (e.equals("D")){
                stack.push(2*stack.peek());
            }else if (e.equals("+")){
                //先将栈顶元素删除，将该元素与新的栈顶元素进行相加
                //再将原来的栈顶元素和新的数值添加到栈中
                int m  = stack.pop();
                int next = m+stack.peek();
                stack.push(m);
                stack.push(next);
            }else {
                stack.push(Integer.valueOf(e));
            }
        }
        //遍历栈中的元素求和
        int res = 0;
        for (Integer e : stack){
            res +=e;
        }
        return res;
    }
}
