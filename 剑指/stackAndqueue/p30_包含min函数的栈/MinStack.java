package stackAndqueue.p30_包含min函数的栈;

import java.util.Stack;

/**
 * ClassName stackAndqueue.p30_包含min函数的栈
 * Description TODO
 * Author 30712
 * Date 2021-05-27
 * Time 17:33
 */
public class MinStack {
    Stack<Integer> stack1;//数据栈,用于存储所有的元素
    Stack<Integer> stack2;//辅助栈，stack2用来维护min的数

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int x) {
        stack1.add(x);
        if (stack2.isEmpty() || stack2.peek() >= x){
            stack2.add(x);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek()) ){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return  stack2.peek();
    }
}
