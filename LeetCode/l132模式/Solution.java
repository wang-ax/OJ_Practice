package l132模式;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName l132模式
 * Description TODO
 * Author 30712
 * Date 2021-03-24
 * Time 23:08
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        //132模式
        //三个连续的数
        //i < j < k
        //nums[i] < nums[k] < nums[j]
        int n = nums.length;
//2是最大的值
        //使用单调栈维护可以作为2的候选元素
        Deque<Integer> candidateK = new LinkedList<Integer>();

        candidateK.push(nums[n - 1]);

        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            //判断nums[i] 是不是可以作为1
            if (nums[i] < maxK) {
                return true;
            }

            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }

            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }
}
