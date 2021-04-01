package 笨阶乘;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName 笨阶乘
 * 求解没有括号的中缀表达式: 遇到乘除立即算，遇到加减先入栈
 * Description TODO
 * Author 30712
 * Date 2021-04-01
 * Time 22:51
 */
public class Solution {
   /* 出现乘法、除法的时候可以把栈顶元素取出，与当前的 N 进行乘法运算、除法运算（除法运算需要注意先后顺序），并将运算结果重新压入栈中；

    出现加法、减法的时候，把减法视为加上一个数的相反数，然后压入栈，等待以后遇见「乘」「除」法的时候取出。*/
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        int index =0;
        while (N > 0){
            if(index %4 == 0){
                stack.push(stack.pop()*N);
            }else if(index % 4 == 1){
                stack.push(stack.pop()/N);
            }else if(index % 4 == 2){
                stack.push(N);
            }else {
                stack.push(-N);
            }
            index++;
            N--;
        }
        //将栈中的所有数字弹出，进行求和
        int sum =0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
