package stackAndqueue.p59_队列的最大值;

/**
 * ClassName stackAndqueue.p59_队列的最大值
 * Description TODO
 * Author 30712
 * Date 2021-05-27
 * Time 17:55
 */
public class MaxQueue1 {
    //暴力解法，实现一个普通队列
    int[] q = new int[2000];
    int begin =0;
    int end =0;
    public MaxQueue1() {
    }

    public int max_value() {
        //遍历队列，遍历的时间复杂度是O(n)
        //每次求最大值的消耗就是队列的长度
        int result =0;
        for (int i = begin; i != end;i++){
            result = Math.max(result,q[i]);
        }
        return result;
    }


    public void push_back(int value) {
        q[end++] = value;
    }

    public int pop_front() {
        if (begin == end){
            return -1;
        }
        return q[begin++];
    }
}
