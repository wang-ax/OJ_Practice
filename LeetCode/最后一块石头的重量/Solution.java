package p_0608.最后一块石头的重量;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName p_0608.最后一块石头的重量
 * Description TODO
 * Author 30712
 * Date 2021-06-08
 * Time 15:04
 */
public class Solution {
    public static int lastStoneWeight(int[] stones){
        //优先级队列
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //创建大根堆，将stones中的元素全部放入堆中
        for (int stone : stones){
            queue.offer(stone);
        }
        while (queue.size()> 1){
            //先取出最重的两个石头
            int y = queue.poll();//y是最重的
            int x = queue.poll();//取出y之后最终的就是x
            if (x != y){
                y = y-x;
                queue.offer(y);
            }
        }
        if (queue.size() >0){
            return queue.peek();
        }else {
            return 0;
        }
    }
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
