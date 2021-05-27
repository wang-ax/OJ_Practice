package stackAndqueue.p59_队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 核心的解决方式是使用一个辅助队列
 * 辅助队列的核心操作：元素入队前，清除比自己更小的元素
 * 篮球队长的模型
 */
//单调队列来降低max_value的复杂度
//本质还是队列，能在尾部插入元素，在头部删除元素。
// 它维护了一个重要的特征：单调性
//维护单调队列的递减性
public class MaxQueue2 {
    Queue<Integer> queue;//主队列:先进先出
    Deque<Integer> deque;//辅助队列，双端队列，用LinkedList来实现
    /**
     * LinkedList的底层实际上是双向链表
     */
    public MaxQueue2() {//构造函数
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
       //最大值是双端队列的队首元素
        if (deque.isEmpty()){
            return -1;//为空，返回-1
        }
        return deque.peek();//deque.getFirst();
    }

    //加入元素
    public void push_back(int value) {
        //主队列正常加入
        queue.add(value);

        //辅助队列，清除尾部比当前值更小的元素
        while (!deque.isEmpty() && deque.getLast() < value){//不能加等号
            //元素在进入辅助队列之前，需要将辅助队列中比自己小的元素清除
            /**
             * 辅助队列中之前比自己小的，都会在主队列中比自己更早的出队，不会起到max的作用，所以再出现在辅助队列中就没有意义了
             */
            deque.removeLast();//保证双端队列存的就是最大的值，将队尾小于value的元素全部删除
        }
        deque.add(value);
    }

    //出队
    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int res = queue.poll();//res是主队列出队的值
        //比较主队列出队的值 是否为 辅助队列的max
        if (!queue.isEmpty() && deque.peekFirst() == res){
            deque.pollFirst();
        }
        return res;
    }
}
