package stackAndqueue.p59_1_滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName stackAndqueue.p59_1_滑动窗口的最大值
 * Description TODO
 * Author 30712
 * Date 2021-05-30
 * Time 14:49
 */
public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        //找出滑动窗口的最大值
        //滑动窗口的个数是nums.length-k+1
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i =0,j=0;i < nums.length;i++){
            //弹出比当前num值小的元素
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]) {
                deque.pollLast();
            }
            // 当队首元素坐标对应的num不在窗口中，需要弹出
            if(!deque.isEmpty() && i-deque.peekFirst()+1>k) {
                deque.pollFirst();
            }
            // 把每次滑动的num下标加入队列
            deque.offerLast(i);
            // 当滑动窗口首地址i大于等于size时才开始写入窗口最大值
            if(i+1 >= k) {
                result[j++] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k =3;
        int[] s = maxSlidingWindow(nums, k);
        for (int num : s){
            System.out.println(num);
        }
    }
}
