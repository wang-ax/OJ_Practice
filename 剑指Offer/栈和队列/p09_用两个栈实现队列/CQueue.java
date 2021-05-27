package stackAndqueue.p09_用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName stackAndqueue.用两个栈实现队列
 * Description TODO
 * Author 30712
 * Date 2021-05-27
 * Time 17:06
 */
class CQueue {
    //使用两个栈实现队列，一个入栈、一出栈
    Deque<Integer>  stack1;
    Deque<Integer>  stack2;

    //构造函数
    public CQueue () {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    //尾插
    public void appendTail(int value) {
        stack1.push(value);
    }

    //头删
    public int deleteHead() {
        if (stack2.isEmpty()){
            //如果stack2为空，就将stack1中的元素添加到stack2中
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //从栈顶取元素
        if (stack2.isEmpty()){
            return  -1;
        }else {
            return stack2.pop();
        }
    }
}
